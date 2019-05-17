
public class Fumador extends Thread {
	// id = 0 --> TABACO
	// id = 1 --> PAPEL
	// id = 2 --> CERILLAS
	
	private int id;
	private Mesa mesa;
	
	public Fumador (int id, Mesa mesa) {
		this.mesa = mesa;
		this.id = id;
	}
	
	public void run() {
		try {
			while (true) {
				mesa.esperarIngredientes(id);
				mesa.fumar(id);
				Thread.sleep(100);
				mesa.finFumar(id);
		
			}
		}catch(InterruptedException e){
		e.printStackTrace();

		}
	}
}