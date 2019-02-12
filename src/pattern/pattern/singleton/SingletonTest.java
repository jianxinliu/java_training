package pattern.pattern.singleton;

/**
 *
 * @author ljx
 * @Date Feb 10, 2019 6:29:14 PM
 *
 */
public class SingletonTest {

	public static void main(String[] args) {
		Sun sun = Sun.getInstance();
		sun.whoami();
		Sun s2 = Sun.getInstance();
		s2.whoami();
		
		SingletonEnum.instance.shine();
		SingletonEnum.instance.shine();
		SingletonEnum.instance.shine();
	}
}
