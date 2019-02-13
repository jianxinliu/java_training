package pattern.pattern.state;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 1:08:43 AM
 *
 */
public class NoMoneyState implements State {
	
	private VendingMachine machine;
	
	public NoMoneyState(VendingMachine v) {
		this.machine = v;
	}

	@Override
	public void insertMoney() {
		System.out.println("insert money success");
		machine.setState(machine.getHasmoney());
	}

	/* 
	 * 
	 */
	@Override
	public void backMoney() {
		System.out.println("no money backable");
	}

	/* 
	 * 
	 */
	@Override
	public void turnCrank() {
		System.out.println("insert money first");
	}

	/* 
	 * 
	 */
	@Override
	public void dispense() {
		System.out.println("...................................");
	}

}
