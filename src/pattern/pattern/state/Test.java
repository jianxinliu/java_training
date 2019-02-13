package pattern.pattern.state;

public class Test {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(10);
		machine.insertMoney();
		machine.backMoney();

		machine.insertMoney();
		machine.turnCrank();
		machine.insertMoney();
		machine.turnCrank();
		machine.insertMoney();
		machine.turnCrank();
		machine.insertMoney();
		machine.turnCrank();
		machine.insertMoney();
		machine.turnCrank();
		machine.insertMoney();
		machine.turnCrank();
		machine.insertMoney();
		machine.turnCrank();

		System.out.println("-------压力测试------");

		machine.insertMoney();
		machine.backMoney();
		machine.backMoney();
		machine.turnCrank();// 无效操作
		machine.turnCrank();// 无效操作
		machine.backMoney();

	}
}