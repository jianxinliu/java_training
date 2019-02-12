package Thread;

/**
 *
 * @author ljx
 * @Date Jan 10, 2019 10:23:37 PM
 *
 */
public class ThreadTest extends Thread {

	static final String KEY = "";
	
	private String name;
	
	public ThreadTest(String name) {
		super();
		this.name = name;
	}
	
	public void test1() {
		// 锁定当前对象，此时锁的 key 是对象的地址，锁的范围是当前对象
		synchronized(this) {
			sleep();
		}
	}
	
	public void test2() {
		// 锁定静态变量，此时锁的 key 是静态变量的地址，锁的范围是静态变量的范围
		synchronized(KEY) {
			sleep();
		}
	}
	
	public void test3() {
		// 锁定当前类，此时锁的 key 是类的字节码，锁的范围是整个字节码的执行范围
		synchronized(ThreadTest.class) {
			sleep();
		}
	}
	
	public void sleep() {
		System.out.println("Start ...."+this.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" End  ...."+this.currentThread().getName());
	}
	
	public static void main(String[] ags) {
//		new Runnable() {
//
//			@Override
//			public void run() {
//				new ThreadTest("------------0----------").start();
//			}
//			
//		}.run();
		new ThreadTest("------------0----------").start();
		new ThreadTest("------------1----------").start();
//		new Runnable() {
//
//			@Override
//			public void run() {
//				new ThreadTest("------------1----------").start();
//			}
//			
//		}.run();
	}

	@Override
	public void run() {
		super.run();
		this.setName(name);
		this.test1();
//		this.test2();
//		this.test3();
	}
	

}
