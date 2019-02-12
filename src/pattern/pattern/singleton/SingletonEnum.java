package pattern.pattern.singleton;

/**
 * 这里的instance即为SingletonEnum类型的引用所以得到它就可以调用枚举中的方法了。
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * @author ljx
 * @Date Feb 10, 2019 9:22:46 PM
 *
 */
public enum SingletonEnum {

	instance;
	
	private SingletonEnum() {}
	
	public void shine() {
		System.out.println("shine from:" + instance.hashCode());
	}
}
