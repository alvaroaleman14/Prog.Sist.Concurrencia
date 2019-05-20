/* Creo mi m�todo hebra que m�s tarde usaremos en el main, solo ejecutar� el m�todo RUN() */
public class HebraTest  extends Thread {
	private char letra;
	public HebraTest(char i) {
		letra = i;
	}
		
	public void run() {
		for (int i = 0; i<10; i++) {
			System.out.println(letra);
		}
	}
	
/* M�todo main */
	
	public static void main (String[]args) {
		HebraTest A = new HebraTest('A');
		HebraTest B = new HebraTest('B');
		HebraTest C = new HebraTest('C');
		
		// Echamos las hebras a correr
		
		A.start();
		B.start();
		C.start();
		
	}
}

//Observamos que cada vez que lo ejecutamos obtenemos un resultado distinto, las hebras
//devuelven el resultado conforme terminan, no conforme se ejecutan