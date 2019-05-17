
public class Mesa {
	//estado = -1 --> Mesa vacia
	//estado = 0,1 o 2 --> Falta tabaco, papel o cerillas
	
	private int estado;
	private boolean fumando; 
	
	public Mesa () {  //mesa vacia y nadie fumando
		estado = -1;
		fumando = false;
	}
	
	synchronized public void esperarIngredientes(int id) throws InterruptedException {
		
		while (estado != id) {
			wait();
			System.out.println("Fumador "+id+ " espera ingredientes");
		}
			
	}

	synchronized public void fumar(int id) {
		
		System.out.println("Fumador "+id+ " puede fumar");
		estado = -1;
		fumando = true;
		
	}

	synchronized public void finFumar(int id) {
		
		System.out.println("Fumador "+id+ " deja de fumar");
		fumando = false;
		notifyAll();
	}

	synchronized public void ponerIngredientes(int igFalta) throws InterruptedException {
		
		if (fumando == true || estado != -1) {
			wait();
			System.out.println("Agente esperando");
		}
		
		estado = igFalta;
		System.out.println("Agente pone ingrediente "+igFalta);
		notifyAll();
		
	}


}
