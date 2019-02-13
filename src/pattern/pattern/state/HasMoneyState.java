package pattern.pattern.state;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 1:12:03 AM
 *
 */
public class HasMoneyState implements State {
	
	private VendingMachine machine;
	
	public HasMoneyState(VendingMachine v) {
		this.machine = v;
	}

	/* 
	 * 
	 */
	@Override
	public void insertMoney() {
		System.out.println("has money");
	}

	/* 
	 * 
	 */
	@Override
	public void backMoney() {
		System.out.println("back money success");
		machine.setState(machine.getNomoney());
	}

	/* 
	 * 
	 */
	@Override
	public void turnCrank() {
		System.out.println("turnCrank....");
		if(machine.getCount() > 0) {
			machine.setState(machine.getSold());
		}else {
			machine.setState(machine.getSoldOut());
		}
	}

	/* 
	 * 
	 */
	@Override
	public void dispense() {
		System.out.println("...................................");
	}

}
