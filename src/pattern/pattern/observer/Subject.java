package pattern.pattern.observer;

/**
 * center
 * @author ljx
 * @Date Feb 10, 2019 10:25:10 PM
 *
 */
public interface Subject {
	
	void register(Observerable observer);
	
	void remove(Observerable observer);
	
	void notifyAllObserver();
}
