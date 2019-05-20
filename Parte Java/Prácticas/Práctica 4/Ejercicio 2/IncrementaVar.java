
public class IncrementaVar extends Thread{
	private VariableCompartida var;
	
	public IncrementaVar(VariableCompartida var) {
		this.var = var;
	}
	
	@Override
	public void run () {
		for (int i = 0; i < 10; i++) {
			var.inc();
		}
	}
}