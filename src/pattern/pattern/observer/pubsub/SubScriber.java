package pattern.pattern.observer.pubsub;

import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author ljx
 * @Date Feb 10, 2019 10:54:30 PM
 *
 */
public class SubScriber implements Observer{
	private String name;
	
	public SubScriber(Observable obser,String name) {
		this.name = name;
		obser.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Publisher publisher = (Publisher) o;
		System.out.println(name+" got msg :"+publisher.getMsg());
	}
	

}
