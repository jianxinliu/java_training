package pattern.pattern.strategy.roles.libai;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 6:34:01 PM
 *
 */
public class Base {
	
	public static final String NAME = "李白";

	private static int moveMax = 3;
	public static boolean move() {
		boolean ret = false;
		moveMax--;
		if(moveMax > 0) {
			ret = true;
			System.out.println(NAME+" move 50 pix");
		} else {
			moveMax = 3;// restore the moveMax
		}
		return ret;
	}
	public static void hurt() {
		System.out.println(NAME+" hurt...");
	}
	
	public static void circle() {
		System.out.println(NAME+" draw a circle");
	}
	
	public static int attack3ActiveTimes = 4;
	
	public static boolean dancing() {
		return attack3ActiveTimes <= 0;
	}
}
