
public class Driver {

	public static void main(String[] args) {
		Control c = new Control(100);
		Proceso[] procesos= new Proceso[10];
		for(int i = 0; i < 10; i++) {
			procesos[i] = new Proceso(i,c);
		}
		
		for (int i = 0; i <10; i++) {
			procesos[i].start();
		}
	}

}
