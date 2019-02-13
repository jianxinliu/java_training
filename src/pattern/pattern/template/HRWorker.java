package pattern.pattern.template;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 12:19:55 AM
 *
 */
public class HRWorker extends Worker {

	public HRWorker(String name) {
		super(name);
	}

	@Override
	protected void work() {
		System.out.println(name + "hire worker........fire worker");
	}

}
