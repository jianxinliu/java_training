package pattern.pattern.facade;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 11:51:51 PM
 *
 */
public class PopcornPopper implements Machine {

	@Override
	public void on() {
		System.out.println(this.getClass().getSimpleName()+" is on!");
	}
	
	@Override
	public void off() {
		System.out.println(this.getClass().getSimpleName()+" is off!");
	}
	
	public void makePopcorn() {
		System.out.println(this.getClass().getSimpleName()+" is make popcorn!");
	}

}
