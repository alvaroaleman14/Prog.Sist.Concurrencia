
package ej3;

public class HebraSet extends Thread {
	
	private VarComp v;
	
	public HebraSet(VarComp var) {
		
		v = var;
	}
	
	@Override
	public void run(){
		
		for (int i = 0; i <100; i++) {
			v.setV(i);
		}
	}
}
