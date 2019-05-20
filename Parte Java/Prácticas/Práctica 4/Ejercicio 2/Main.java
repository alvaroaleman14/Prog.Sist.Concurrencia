
public class Main {

	public static void main(String[] args) {
		VariableCompartida v = new VariableCompartida();
		
		
		IncrementaVar h1, h2;
		
		h1 = new IncrementaVar(v);
		h2 = new IncrementaVar(v);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
			
			System.out.println("El valor de la variable es: " + v.getV());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

	}

}
