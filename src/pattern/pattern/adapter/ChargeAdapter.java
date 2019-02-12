package pattern.pattern.adapter;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 12:05:19 AM
 *
 */
public class ChargeAdapter implements Plug{
	
	private V5Plug v5 = new V5Plug();
	private V220Plug v220;

	public ChargeAdapter(V220Plug v220) {
		this.v220 = v220;
	}
	
	public V5Plug getPlug() {
		return v5;
	}

	
}
