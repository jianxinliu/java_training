package reflection;

import java.lang.reflect.Field;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 11:21:43 AM
 *
 */
public class Test {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Obj o = new Obj("qw",32,"sfg");
		Field[] declaredFields = o.getClass().getDeclaredFields();
		for(Field f : declaredFields) {
			f.setAccessible(true);
			System.out.printf("%-20s", f.getName());
		}
	}
}
