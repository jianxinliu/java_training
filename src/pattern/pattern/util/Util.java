package pattern.pattern.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 7:04:13 PM
 *
 */
public class Util {

	/**
	 * generic properties reader
	 * @param maps properties map
	 * @param clazz control panel class(where need the properties)
	 * @param profileName profile name
	 * @return properties map
	 */
	public static <T> Map<String,T> getProps(Map<String,T> maps,Class<?> clazz,String profileName){
		Properties p = new Properties();
		
		if(maps == null)
			maps = new HashMap<String,T>();
		
		try {
			p.load(clazz.getResourceAsStream(profileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Object e : p.keySet()) {
			String className = String.valueOf(p.get(e));
			String key = String.valueOf(e);
			try {
				maps.put(key, (T)Class.forName(className).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return maps;
	}
}
