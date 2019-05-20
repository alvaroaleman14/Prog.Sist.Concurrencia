package ej5;

public class PrincipalEj5 {

	public static void main(String[] args) {
		long numero = 20L;

		Fibonodo fibo = new Fibonodo(numero);
		fibo.start();
		
		try {
			fibo.join();
			System.out.println("Fibonacci de " + numero + " es " + fibo.getSol());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
