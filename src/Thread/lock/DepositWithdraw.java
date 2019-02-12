package Thread.lock;

import java.math.BigDecimal;

/**
 *
 * @author ljx
 * @Date Jan 15, 2019 11:32:05 AM
 *
 */
public class DepositWithdraw {
	
	public static void main(String[] asc) {
		
		Account a = new Account("a",new BigDecimal("40"));
		
		Deposit deposit = new Deposit(a,"10");
		Withdraw withdraw = new Withdraw(a,"50");
		
		System.out.println("account amount:"+a.amount);
		deposit.start();
		withdraw.start();
//		System.out.println("account amount:"+dw.a.amount);
	}
}