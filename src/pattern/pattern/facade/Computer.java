package pattern.pattern.facade;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 11:47:27 PM
 *
 */
public class Computer implements Machine {

	@Override
	public void on() {
		System.out.println(this.getClass().getSimpleName()+" is on!");
	}
	
	@Override
	public void off() {
		System.out.println(this.getClass().getSimpleName()+" is off!");
	}
	
	public void searchMovie() {
		System.out.println(this.getClass().getSimpleName()+" is search movie!");
	}

	public void plaMovie() {
		System.out.println(this.getClass().getSimpleName()+" is play movie!");
	}
}
