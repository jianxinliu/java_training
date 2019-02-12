package pattern.pattern.observer;

/**
 *
 * @author ljx
 * @Date Feb 10, 2019 10:16:06 PM
 *
 */
public class ObserverTest{

	public static void main(String[] args) {
		Center c = new Center();
		new Observer(c,"tom");
		new Observer(c,"jerry");
		
		for(int i = 0;i<4;i++) {
			// publish mew message
			c.setMsg("msg"+(i+1));
		}
	}
}
