import java.util.Random;

public class Proceso extends Thread{
	private int id;
	private Control control;
	private Random r;

public Proceso (int id,Control c){
	this.id = id;
	this.control = c;
	r = new Random();
}

public void run(){
	try{
		while(true){
			Thread.sleep(r.nextInt(100));
			int recursos = 1+r.nextInt(100);
			control.qrecursos(id, recursos);
			Thread.sleep(r.nextInt(100));
			control.librerecursos(id,recursos);
		}
	}catch(InterruptedException e){
		e.printStackTrace();
	}
}
}
