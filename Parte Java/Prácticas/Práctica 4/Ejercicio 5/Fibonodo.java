package ej5;

public class Fibonodo extends Thread {
	private long n, sol, soli;

	public Fibonodo(long n) {
		this.n = n;
	}

	public long getSol() {
		return sol;
	}
	
	private long getSoli() {
		return soli;
	}

	public void run() {
		if (n == 0) {
			sol = 0L;
			soli = 0L;
		} else if (n == 1) {
			sol = 1L;
			soli = 0L;
		} else {
			Fibonodo f = new Fibonodo(n-1);

			f.start();

			try {
				f.join();

				sol = f.getSol() + f.getSoli();
				soli = f.getSol();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
