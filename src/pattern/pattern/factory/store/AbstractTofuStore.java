package pattern.pattern.factory.store;

import pattern.pattern.factory.tofu.Tofu;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 1:34:16 AM
 *
 */
public abstract class AbstractTofuStore implements Store{

	public abstract Tofu create(String type);
	
	public Tofu sell(String type) {
		return create(type);
	}
}
