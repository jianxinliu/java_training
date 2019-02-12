package pattern.pattern.singleton;

/**
 * singleton example
 * @author ljx
 * @Date Feb 10, 2019 6:30:25 PM
 *
 */
public class Sun {

	// instant instantly
	private static Sun me = new Sun();
	
	private static Sun self;
	
	private Sun() {}
	
	// instantly and not lazy load
	public static Sun getInstance() {
		return me;
	}
	
	// lazy load and thread safe
	public static Sun getInstance2() {
		if(self == null) {
			synchronized(Sun.class) {
				if(self == null) {
					self = new Sun();
				}
			}
		}
		return self;
	}
	
	private static class SunHolder{
		private static Sun sun = new Sun();
	}
	
	// inner class ,lazy load
	public static Sun getInstance3() {
		return SunHolder.sun;
	}
	
	public void whoami() {
		System.out.println("I am "+me.hashCode());
	}
}
