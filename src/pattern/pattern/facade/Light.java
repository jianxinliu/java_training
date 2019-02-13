package pattern.pattern.facade;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 11:50:24 PM
 *
 */
public class Light implements Machine {

	@Override
	public void on() {
		System.out.println(this.getClass().getSimpleName()+" is on!");
	}
	
	@Override
	public void off() {
		System.out.println(this.getClass().getSimpleName()+" is off!");
	}

}
