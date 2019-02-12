package pattern.pattern.observer.pubsub;

/**
 *
 * @author ljx
 * @Date Feb 10, 2019 11:05:37 PM
 *
 */
public class PubSubTest {

	public static void main(String[] args) {
		Publisher pub = new Publisher();
		SubScriber sub1 = new SubScriber(pub,"tom");
		SubScriber sub2 = new SubScriber(pub,"jerry");
		
		for(int i = 0;i<4;i++) {
			// publish mew message
			pub.setMsg("msg"+(i+1));
		}
	}
}
