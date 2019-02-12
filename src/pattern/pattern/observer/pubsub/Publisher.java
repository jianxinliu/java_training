package pattern.pattern.observer.pubsub;

import java.util.Observable;
/**
 *
 * @author ljx
 * @Date Feb 10, 2019 10:51:01 PM
 *
 */
public class Publisher extends Observable{

	private String msg;
	
	public String getMsg() {
		return this.msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		setChanged();
		notifyObservers();
	}
}
