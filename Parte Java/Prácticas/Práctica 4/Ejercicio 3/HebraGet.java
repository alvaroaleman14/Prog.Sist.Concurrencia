package ej3;

public class HebraGet extends Thread{

	private VarComp v;
	
	public HebraGet (VarComp var) {
		
		v = var;
	}
	
	@Override
	public void run () {
		
		for (int i = 0; i <100 ; i++) {
			System.out.print(+v.getV()+ " ");
		}
		
	}
}
