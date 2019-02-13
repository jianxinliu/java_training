package pattern.pattern.facade;

/**
 * no facade
 * @author ljx
 * @Date Feb 12, 2019 11:54:27 PM
 *
 */
public class HomeTheaterFacade {
	
	private Computer computer = new Computer();
	private Mixer mixer = new Mixer();
	private Player player = new Player();
	private Light light = new Light();
	private PopcornPopper popcorn = new PopcornPopper();
	
	public void watchMovie() {
		popcorn.on();
		popcorn.makePopcorn();
		
		light.on();
		computer.on();
		mixer.on();
		player.on();
		computer.searchMovie();
		computer.plaMovie();
	}
	
	public void stopMovie() {
		popcorn.off();
		computer.off();
		light.off();
		mixer.off();
		player.off();
	}
}
