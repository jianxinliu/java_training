package pattern.pattern.factory;

import pattern.pattern.factory.store.TofuStore;
import pattern.pattern.factory.util.Util;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 12:29:05 AM
 *
 */
public class TofuTest {

	public static void main(String[] arge) {
		TofuStore mystore = new TofuStore(new TofuFactory());
//		ShanghaiTofuStore mystore = new ShanghaiTofuStore();
		Util.interpreter(mystore);
	}
}
