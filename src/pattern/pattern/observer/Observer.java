package pattern.pattern.observer;

/**
 *
 * @author ljx
 * @Date Feb 10, 2019 10:39:13 PM
 *
 */
public class Observer implements Observerable{
	
	private Subject subject;
	private String name;
	
	// register me
	public Observer(Subject subject,String name) {
		this.subject = subject;
		this.name = name;
		this.subject.register(this);
	}

	@Override
	public void update(String msg) {
		System.out.println(name + " got new message:"+msg);
	}

}
