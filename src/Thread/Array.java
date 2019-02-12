package Thread;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 被竞争的资源
 * @author ljx
 * @Date Jan 13, 2019 1:27:11 PM
 *
 */
public class Array {

	private List<Integer> arr;
	final Lock lock = new ReentrantLock();
	final Condition canTake = lock.newCondition();
	final Condition canPush = lock.newCondition();
	
	private int cur = 1;
	private int curOrder = 1;
	final Lock lock2 = new ReentrantLock();
	final Condition odd = lock2.newCondition();
	final Condition even = lock2.newCondition();
	
	public Array(List<Integer> i) {
		this.arr = i;
	}
	
	/**
	 * 无锁控制的奇数打印
	 */
	public void odd() {
		for (int i = 0 ;i<=10;i++) {
			if(cur %2 != 0) {
				System.out.println(Thread.currentThread().getName()+":"+cur);
			}
			cur ++;
		}
	}
	
	/**
	 * 无所控制的偶数打印
	 */
	public void even() {
		for (int i = 0 ;i<=10;i++) {
			if(cur %2 == 0) {
				System.out.println(Thread.currentThread().getName()+":"+cur);
			}
			cur ++;
		}
	}
	
	public void oddOrder() {
		lock2.lock();
		try {
			if(cur % 2 != 0) {
				odd.await();
			}
			System.out.println(Thread.currentThread().getName()+":"+curOrder);
			curOrder++;
			even.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock2.unlock();
		}
	}
	
	public void evenOrder() {
		lock2.lock();
		try {
			if(cur % 2 == 0) {
				even.await();
			}
			System.out.println(Thread.currentThread().getName()+":"+curOrder);
			curOrder++;
			odd.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock2.unlock();
		}
	}
	
	public void push(Integer i) {
		lock.lock();
		try {
			while(arr.size() >= 1) {
				canPush.await();
			}
			arr.add(i);
			canTake.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void pop() throws Exception {
		lock.lock();
		try {
			while(arr.size() <= 0) {
				canTake.await();
			}
			arr.remove(0);
			canPush.signal();
		}finally {
			lock.unlock();
		}
	}
}
