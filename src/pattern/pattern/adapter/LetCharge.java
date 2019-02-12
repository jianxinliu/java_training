package pattern.pattern.adapter;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 12:06:06 AM
 *
 */
public class LetCharge {

	public static void main(String[] args) {
		Mobile m = new Mobile();
		V220Plug source = new V220Plug();
		m.charge(new ChargeAdapter(source).getPlug());
	}
}
