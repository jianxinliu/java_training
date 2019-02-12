package pattern.pattern.factory;

import java.util.Map;

import pattern.pattern.factory.tofu.Tofu;
import pattern.pattern.factory.util.Util;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 12:11:57 AM
 *
 */
public class TofuFactory {
	
	private static Map<String,Tofu> tofuMaps;

	static {
		tofuMaps = Util.getTofuTypes("TofuTypes.properties");
	}
	
	public static Tofu getTofu(String type) {
		return tofuMaps.get(type);
	}
}
