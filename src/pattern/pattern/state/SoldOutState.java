package pattern.pattern.state;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 1:12:52 AM
 *
 */
public class SoldOutState implements State {

	private VendingMachine machine;

	public SoldOutState(VendingMachine v) {
		this.machine = v;
	}

	@Override
	public void insertMoney() {
		System.out.println("投币失败，商品已售罄");
	}

	@Override
	public void backMoney() {
		System.out.println("您未投币，想退钱么？...");
	}

	@Override
	public void turnCrank() {
		System.out.println("商品售罄，转动手柄也木有用");
	}

	@Override
	public void dispense() {
		System.out.println("...................................");
	}
}
