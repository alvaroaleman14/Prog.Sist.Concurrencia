
public class Driver {

	public static void main(String[] args) {
		
		Mesa mesa = new Mesa();
		Agente agente = new Agente(mesa);
		Fumador[] fumadores = new Fumador[3];
		
		for (int i = 0; i < 3; i++) {
			fumadores[i] = new Fumador(i,mesa);
		}
		agente.start();
		
		for (int i = 0; i < 3; i++) {
			fumadores[i].start();
		}
	}

}
