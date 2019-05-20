package ej3;

public class VarComp {
	private int v;
	private boolean escribo = true;
	

	public void setV(int val) {
		
		while (!escribo) {
			Thread.yield();
		}
		
		this.v = val;
		escribo = false;
	}
	
	public int getV() {
		while (escribo) {
			Thread.yield();
		}
		escribo = true;
		return v;
	}


}

