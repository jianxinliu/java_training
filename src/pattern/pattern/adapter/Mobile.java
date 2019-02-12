package pattern.pattern.adapter;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 11:44:05 PM
 *
 */
public class Mobile {

	private final static int outlet_volt = 5;
	
	public void charge(V5Plug plug) {
		if(plug.volt == outlet_volt) {
			System.out.println("I am charging on "+ plug.volt + " volt");
		} else {
			System.out.println("Destoryed!I can only work on "+outlet_volt+" volt");
		}
	}
}
