package ej3;

public class Main {
	
	public static void main(String[] args) {
		
		VarComp v = new VarComp();
		
		HebraSet set = new HebraSet(v);
		HebraGet get = new HebraGet(v);
		
		set.start();
		get.start();
		
		
	}

}
