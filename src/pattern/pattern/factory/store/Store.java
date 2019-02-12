package pattern.pattern.factory.store;

import pattern.pattern.factory.tofu.Tofu;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 1:50:23 AM
 *
 */
public interface Store {

	Tofu sell(String type);
}
