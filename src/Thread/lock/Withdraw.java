package Thread.lock;

import java.math.BigDecimal;

/**
 *
 * @author ljx
 * @Date Jan 15, 2019 11:27:56 AM
 *
 */
public class Withdraw extends Thread{

	private Account account;
	private String val;
	
	public Withdraw(Account a,String val) {
		this.account = a;
		this.val = val;
	}
	
	@Override
	public void run() {
		BigDecimal money = this.account.withdraw(this.val);
		if(money.compareTo(new BigDecimal("-1")) != 0) {
			System.out.println("withdraw money:"+money+" ,amount:"+account.amount);
		}
	}
}
