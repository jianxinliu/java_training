package pattern.pattern.factory.store;

import pattern.pattern.factory.TofuFactory;
import pattern.pattern.factory.tofu.Tofu;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 12:26:34 AM
 *
 */
public class TofuStore implements Store{

	private TofuFactory factory;
	
	public TofuStore(TofuFactory fa) {
		this.factory = fa;
	}
	
	public Tofu sell(String type) {
		return factory.getTofu(type);
	}
}
