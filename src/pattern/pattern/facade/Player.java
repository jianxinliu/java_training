package pattern.pattern.facade;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 11:50:04 PM
 *
 */
public class Player implements Machine {

	@Override
	public void on() {
		System.out.println(this.getClass().getSimpleName()+" is on!");
	}
	
	@Override
	public void off() {
		System.out.println(this.getClass().getSimpleName()+" is off!");
	}

}
