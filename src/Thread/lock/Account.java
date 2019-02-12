package Thread.lock;

import java.math.BigDecimal;

/**
 * 基于锁实现存取钱操作
 * @author ljx
 * @Date Jan 15, 2019 10:45:30 AM
 *
 */
public class Account {

	BigDecimal amount ;
	private Lock lock = new Lock();
	private String name ;
	public Account(String name,BigDecimal amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public boolean deposit(String i) {
		lock.lock1(name);
		try {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			amount = amount.add(new BigDecimal(i));
		}finally {
			lock.unlock();
		}
		return true;
	}
	
	public BigDecimal withdraw(String i) {
		lock.lock1(name);
		BigDecimal ret = new BigDecimal(i);
		try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(new BigDecimal(i).compareTo(this.amount) > 0) {
				System.out.println("withdraw fail ,amount not enough");
				return new BigDecimal("-1");
			}else {
				amount = amount.subtract(ret);
				return ret;
			}
		}finally {
			lock.unlock();
		}
		
	}
}
