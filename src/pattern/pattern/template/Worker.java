package pattern.pattern.template;

import java.util.Date;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 12:13:12 AM
 *
 */
public abstract class Worker {

	protected String name;
	
	public Worker(String name) {
		this.name = name;
	}
	
	public void workOneday() {
		System.out.println("............."+name + " work start"+".............");
		enterCompany();
		computerOn();
		work();
		computerOff();
		leaveCompany();
		System.out.println("............."+name + " work end"+".............");
	}
	
	protected abstract void work();
	
	protected boolean needPrintDate() {
		return false;
	}
	
	private void enterCompany() {
		System.out.println(name + " is enter company");
	}
	private void leaveCompany() {
		if(needPrintDate()) {
			System.out.println(name + " .........is leave company at "+ new Date().toLocaleString());
		}else {
			System.out.println(name + " is leave company");
		}
	}
	private void computerOn() {
		System.out.println(name + " computer on");
	}
	private void computerOff() {
		System.out.println(name + " computer off");
	}
}
