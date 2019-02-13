package pattern.pattern.state;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 1:09:09 AM
 *
 */
public class VendingMachine {

	private State nomoney;
	private State hasmoney;
	private State sold;
	private State soldOut;

	private int count = 5;
	private State currentState = nomoney;

	public VendingMachine(int count) {
		nomoney = new NoMoneyState(this);
		hasmoney = new HasMoneyState(this);
		sold = new SoldState(this);
		soldOut = new SoldOutState(this);

		if (count > 0) {
			this.count = count;
			currentState = nomoney;
		}
	}

	public void insertMoney() {
		currentState.insertMoney();
	}

	public void backMoney() {
		currentState.backMoney();
	}

	public void turnCrank() {
		currentState.turnCrank();
		if (currentState == sold) {
			dispense();
		}
	}

	public void dispense() {
		System.out.println("发出一件商品...");
		if (count != 0) {
			count -= 1;
		}
	}

	public State getNomoney() {
		return nomoney;
	}

	public void setNomoney(State nomoney) {
		this.nomoney = nomoney;
	}

	public State getHasmoney() {
		return hasmoney;
	}

	public void setHasmoney(State hasmoney) {
		this.hasmoney = hasmoney;
	}

	public State getSold() {
		return sold;
	}

	public void setSold(State sold) {
		this.sold = sold;
	}

	public State getSoldOut() {
		return soldOut;
	}

	public void setSoldOut(State soldOut) {
		this.soldOut = soldOut;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setState(State s) {
		this.currentState = s;
	}
}
