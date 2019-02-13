package pattern.pattern.facade;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 12:04:48 AM
 *
 */
public class RemoteControl {

	public static void main(String[] args) {
		HomeTheaterFacade home = new HomeTheaterFacade();
		home.watchMovie();
		System.out.println("---------------------------");
		home.stopMovie();
	}
}
