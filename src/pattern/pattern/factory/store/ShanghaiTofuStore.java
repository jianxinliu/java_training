package pattern.pattern.factory.store;

import java.util.Map;

import pattern.pattern.factory.tofu.Tofu;
import pattern.pattern.factory.util.Util;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 1:36:24 AM
 *
 */
public class ShanghaiTofuStore extends AbstractTofuStore implements Store{

	// shanghai tofu store make his own tofu type
	private static Map<String, Tofu> tofuTypes;
	
	static {
		tofuTypes = Util.getTofuTypes("shanghaiTofuTypes.properties");
	}
	
	@Override
	public Tofu create(String type) {
		return tofuTypes.get(type);
	}
}
