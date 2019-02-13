package pattern.pattern.template;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 12:21:05 AM
 *
 */
public class Company {

	public static void main(String[] args) {
		Worker it = new ITWorker("jack");
		Worker hr = new HRWorker("mary");
		
		it.workOneday();
		hr.workOneday();
	}
}
