package pattern.pattern.template;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 12:18:07 AM
 *
 */
public class ITWorker extends Worker{

	public ITWorker(String name) {
		super(name);
	}

	@Override
	public void work() {
		System.out.println(name + "coding..... fix bug......");
	}

	@Override
	protected boolean needPrintDate() {
		return true;
	}
}
