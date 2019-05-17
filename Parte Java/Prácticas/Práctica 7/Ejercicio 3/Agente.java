import java.util.Random;

public class Agente extends Thread {
	private Mesa mesa;
	Random igFalta;
	
	public Agente(Mesa m) {
		this.mesa = m;
		igFalta = new Random();
	}
	
	public void run() {
		while(true) {
			try {
				mesa.ponerIngredientes(igFalta.nextInt(3)); //nextInt nos devuelve desde 0 incluido hasta el
															// numero que ponemos excluido, es decir, 0 1 2 en este caso
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	
	
	

}
