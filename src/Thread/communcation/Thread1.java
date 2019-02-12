package Thread.communcation;

/**
 *
 * @author ljx
 * @Date Jan 15, 2019 1:33:17 PM
 *
 */
public class Thread1 extends Thread{

	Pool pool;
	public Thread1(Pool p) {
		this.pool = p;
	}
	
    @Override
	public void run() {
//		System.out.println(this.currentThread().getName()+" create.....");
//		System.out.println(currentThread().getName()+"   :   "+pool.get());
		try {
            for (int i = 0; i < 5; i++) {
                synchronized (pool) {// 第三方对象
                    if (pool.ptr % 2 != 0)
                    	pool.wait();
                    System.out.println(currentThread().getName()+"   :   "+pool.get());
                    pool.notify();// 等在 pool 对象监视器上的线程可以醒过来了，我完事了
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Oops...");
        }
	}
}

/**
 * Open Declarationvoid java.lang.Object.wait() throws InterruptedException

wait
public final void wait()
                throws InterruptedException
Causes the current thread to wait until another thread invokes the notify() method or the notifyAll() method for this object. In other words, this method behaves exactly as if it simply performs the call wait(0).
The current thread must own this object's monitor. The thread releases ownership of this monitor and waits until another thread notifies threads waiting on this object's monitor to wake up either through a call to the notify method or the notifyAll method. The thread then waits until it can re-obtain ownership of the monitor and resumes execution.
As in the one argument version, interrupts and spurious wakeups are possible, and this method should always be used in a loop:
     synchronized (obj) {
         while (<condition does not hold>)
             obj.wait();
         ... // Perform action appropriate to condition
     }
 
This method should only be called by a thread that is the owner of this object's monitor. See the notify method for a description of the ways in which a thread can become the owner of a monitor.
Throws:
IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.
InterruptedException - if any thread interrupted the current thread before or while the current thread was waiting for a notification. The interrupted status of the current thread is cleared when this exception is thrown.
See Also:
notify(), notifyAll()
 */


/**
 * Open Declarationvoid java.lang.Object.notify()

notify
public final void notify()
Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be awakened. The choice is arbitrary and occurs at the discretion of the implementation. A thread waits on an object's monitor by calling one of the wait methods.
The awakened thread will not be able to proceed until the current thread relinquishes the lock on this object. The awakened thread will compete in the usual manner with any other threads that might be actively competing to synchronize on this object; for example, the awakened thread enjoys no reliable privilege or disadvantage in being the next thread to lock this object.
This method should only be called by a thread that is the owner of this object's monitor. A thread becomes the owner of the object's monitor in one of three ways:
By executing a synchronized instance method of that object.
By executing the body of a synchronized statement that synchronizes on the object.
For objects of type Class, by executing a synchronized static method of that class.
Only one thread at a time can own an object's monitor.
Throws:
IllegalMonitorStateException - if the current thread is not the owner of this object's monitor.
See Also:
notifyAll(), wait()
 */
