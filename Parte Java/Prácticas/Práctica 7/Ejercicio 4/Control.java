import java.util.ArrayList;

public class Control {
	
	private int maxRecursos;
	private int recursosDisponibles;
	private ArrayList <Integer>colaPeticiones;
	private boolean esperaRecursos; //controlar los recursos disponibles para proceso con turno
	private boolean esMiTurno; //controla turno procesos
	private int turno; //turno del proceso
	
	public Control (int maxRecursos) {
		this.maxRecursos = maxRecursos;
		recursosDisponibles = maxRecursos;
		colaPeticiones = new <Integer> ArrayList();
	}
	
	synchronized public void qrecursos (int id, int num) throws InterruptedException {
		
		if (colaPeticiones.isEmpty()) {
			turno = id;
		}
		
		colaPeticiones.add(id);
		System.out.println("Proceso "+id+ " encola peticion recursos "+num);
		
		while (turno != id) {  //si la variable turno dice que no es mi turno me bloqueo en la cola de peticiones
			wait();
		}
		while (recursosDisponibles < num) {
			wait();
		}
		
		
		recursosDisponibles -= num;
		System.out.println("Proceso "+id+ " reserva "+num+ " recursos " +recursosDisponibles+ " Total recursos");
		colaPeticiones.remove(0); //nos quitamos ya del id y tenemos que darle el turno al primero de la cola
		//tenemos que notificar tambien al resto para que se despierten
		
		if (!colaPeticiones.isEmpty()) {  //si no está vacía le damos el turno 
			turno = colaPeticiones.get(0);
			notify();
		}
		
			
		
	}
	
	synchronized public void librerecursos (int id, int num) {
		recursosDisponibles += num;
		System.out.println("Proceso "+id+ " libera recursos " +num+ " Total recursos " +recursosDisponibles);
		notifyAll();
	}
}
