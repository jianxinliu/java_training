package pattern.pattern.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * message center,manage observers
 * @author ljx
 * @Date Feb 10, 2019 10:34:33 PM
 *
 */
public class Center implements Subject{
	
	private List<Observerable> observers = new LinkedList<Observerable>();
	
	private String msg;

	/* 
	 * 
	 */
	@Override
	public void register(Observerable observer) {
		this.observers.add(observer);
	}

	/* 
	 * 
	 */
	@Override
	public void remove(Observerable observer) {
		this.observers.remove(observer);
	}

	/* 
	 * 
	 */
	@Override
	public void notifyAllObserver() {
		for(Observerable o : observers) {
			o.update(msg);
		}
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		notifyAllObserver();
	}

}
