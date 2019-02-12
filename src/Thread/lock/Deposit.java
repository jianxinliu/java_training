package Thread.lock;

/**
 *
 * @author ljx
 * @Date Jan 15, 2019 11:22:29 AM
 *
 */
public class Deposit extends Thread{

	private Account account;
	private String val;
	
	public Deposit(Account a,String val) {
		this.account = a;
		this.val = val;
	}
	
	@Override
	public void run() {
		boolean v = this.account.deposit(this.val);
		System.out.println("deposit money "+v+" ,amount:"+account.amount);
	}
}
