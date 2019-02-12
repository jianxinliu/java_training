package pattern.pattern.strategy.roles;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import pattern.pattern.strategy.Role;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 7:11:29 PM
 *
 */
public class HerosUtil {

	public static Map<String,Role> getHeros(String profileName){
		Map<String,Role> heroMaps = new HashMap<String,Role>();
		Properties p = new Properties();
		try {
			p.load(Role.class.getResourceAsStream(profileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Object e : p.keySet()) {
			String className = String.valueOf(p.get(e));
			String key = String.valueOf(e);
			try {
				heroMaps.put(key, (Role)Class.forName(className).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return heroMaps;
	}
}
