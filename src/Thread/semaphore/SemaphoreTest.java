package Thread.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 信号量： 信号量维护了一些许可证，每一个 acquire() 方法在获取到许可证之前，如果当前没有可用的许可证，就会被阻塞，然后才能拿到许可证。 每个
 * release() 方法添加一个许可证，潜在得释放一个被阻塞的获取者。但是，并没有实际的许可证，Semaphore 只是维护了可用许可证的数量。
 * 
 * 信号量常常用来限制访问某些资源（物理的或逻辑的）的线程数量
 * 
 * @author ljx
 * @Date Jan 16, 2019 9:58:47 AM
 *
 */
public class SemaphoreTest {

	static class Passenger implements Runnable {

		private Bus bus;
		private String name;

		public Passenger(Bus bus, String name) {
			this.bus = bus;
			this.name = name;
		}

		@Override
		public void run() {
			try {
				int seat = bus.getSeat();
				System.out.println("Passenger " + name + " get a seat: " + seat);
				Thread.sleep((int) (Math.random() * 5000));
				bus.debus(seat);
				System.out.println("           Passenger " + name + " debus,seat: " + seat + " is useable");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Executor exe = Executors.newCachedThreadPool();
		Bus bus = new Bus();
		for (int i = 0; i < 8; i++) {
			exe.execute(new Passenger(bus,"P"+(i+1)));
		}
		
	}
}

/**
 * Open Declarationjava.util.concurrent.Semaphore
 * 
 * A counting semaphore. Conceptually, a semaphore maintains a set of permits.
 * Each acquire() blocks if necessary until a permit is available, and then
 * takes it. Each release() adds a permit, potentially releasing a blocking
 * acquirer. However, no actual permit objects are used; the Semaphore just
 * keeps a count of the number available and acts accordingly.
 * 
 * Semaphores are often used to restrict the number of threads than can access
 * some (physical or logical) resource. For example, here is a class that uses a
 * semaphore to control access to a pool of items:
 * 
 * 
class Pool {
   private static final int MAX_AVAILABLE = 100;
   private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

   public Object getItem() throws InterruptedException {
     available.acquire();
     return getNextAvailableItem();
   }

   public void putItem(Object x) {
     if (markAsUnused(x))
       available.release();
   }

   // Not a particularly efficient data structure; just for demo

   protected Object[] items = ... whatever kinds of items being managed
   protected boolean[] used = new boolean[MAX_AVAILABLE];

   protected synchronized Object getNextAvailableItem() {
     for (int i = 0; i < MAX_AVAILABLE; ++i) {
       if (!used[i]) {
          used[i] = true;
          return items[i];
       }
     }
     return null; // not reached
   }

   protected synchronized boolean markAsUnused(Object item) {
     for (int i = 0; i < MAX_AVAILABLE; ++i) {
       if (item == items[i]) {
          if (used[i]) {
            used[i] = false;
            return true;
          } else
            return false;
       }
     }
     return false;
   }
 }
 * Before obtaining an item each thread must acquire a permit from the semaphore,
 * guaranteeing that an item is available for use. When the thread has finished
 * with the item it is returned back to the pool and a permit is returned to the
 * semaphore, allowing another thread to acquire that item. Note that no
 * synchronization lock is held when acquire() is called as that would prevent
 * an item from being returned to the pool. The semaphore encapsulates the
 * synchronization needed to restrict access to the pool, separately from any
 * synchronization needed to maintain the consistency of the pool itself.
 * 
 * A semaphore initialized to one, and which is used such that it only has at
 * most one permit available, can serve as a mutual exclusion lock. This is more
 * commonly known as a binary semaphore, because it only has two states: one
 * permit available, or zero permits available. When used in this way, the
 * binary semaphore has the property (unlike many Lock implementations), that
 * the "lock" can be released by a thread other than the owner (as semaphores
 * have no notion of ownership). This can be useful in some specialized
 * contexts, such as deadlock recovery.
 * 
 * The constructor for this class optionally accepts a fairness parameter. When
 * set false, this class makes no guarantees about the order in which threads
 * acquire permits. In particular, barging is permitted, that is, a thread
 * invoking acquire() can be allocated a permit ahead of a thread that has been
 * waiting - logically the new thread places itself at the head of the queue of
 * waiting threads. When fairness is set true, the semaphore guarantees that
 * threads invoking any of the acquire methods are selected to obtain permits in
 * the order in which their invocation of those methods was processed
 * (first-in-first-out; FIFO). Note that FIFO ordering necessarily applies to
 * specific internal points of execution within these methods. So, it is
 * possible for one thread to invoke acquire before another, but reach the
 * ordering point after the other, and similarly upon return from the method.
 * Also note that the untimed tryAcquire methods do not honor the fairness
 * setting, but will take any permits that are available.
 * 
 * Generally, semaphores used to control resource access should be initialized
 * as fair, to ensure that no thread is starved out from accessing a resource.
 * When using semaphores for other kinds of synchronization control, the
 * throughput advantages of non-fair ordering often outweigh fairness
 * considerations.
 * 
 * This class also provides convenience methods to acquire and release multiple
 * permits at a time. Beware of the increased risk of indefinite postponement
 * when these methods are used without fairness set true.
 * 
 * Memory consistency effects: Actions in a thread prior to calling a "release"
 * method such as release() happen-before actions following a successful
 * "acquire" method such as acquire() in another thread.
 * 
 */