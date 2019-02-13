package pattern.pattern.state;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 1:13:11 AM
 *
 */
public class SoldState implements State {

	private VendingMachine machine;

	public SoldState(VendingMachine v) {
		this.machine = v;
	}

	@Override
	public void insertMoney() {
		System.out.println("正在出货，请勿投币");
	}

	@Override
	public void backMoney() {
		System.out.println("正在出货，没有可退的钱");
	}

	@Override
	public void turnCrank() {
		System.out.println("正在出货，请勿重复转动手柄");
	}

	@Override
	public void dispense() {
		machine.dispense();
		if (machine.getCount() > 0) {
			machine.setState(machine.getNomoney());
		} else {
			System.out.println("商品已经售罄");
			machine.setState(machine.getSoldOut());
		}
	}
}
