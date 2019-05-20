import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	
	public static void main(String[] args) {
		
		Random r = new Random();
		
		List<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			lista.add(r.nextInt(100));
		}
		
		Nodo raiz = new Nodo(lista);
		
		System.out.println("Lista sin ordenar --> "+lista);
		
		raiz.start();
		
		try {
			raiz.join();
			System.out.println("Lista ordenada --> " +lista);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
