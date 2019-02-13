package pattern.pattern.factory.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import pattern.pattern.factory.TofuFactory;
import pattern.pattern.factory.store.Store;
import pattern.pattern.factory.tofu.Tofu;

/**
 * another factory pattern
 * @author ljx
 * @Date Feb 11, 2019 1:37:57 AM
 *
 */
public class Util {

	@Deprecated
	public static Map<String,Tofu> getTofuTypes(String profileName){
		Map<String,Tofu> tofuMaps = new HashMap<String,Tofu>();
		Properties p = new Properties();
		try {
			p.load(TofuFactory.class.getResourceAsStream(profileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Object e : p.keySet()) {
			String className = String.valueOf(p.get(e));
			String key = String.valueOf(e);
			try {
				tofuMaps.put(key, (Tofu)Class.forName(className).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		return tofuMaps;
	}
	
	public static void interpreter(Store mystore) {
		System.out.println("which type of tofu do you want?");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String type = sc.nextLine();
			if("Q".equals(type) || "q".equals(type)) {
				System.out.println("Welcome to visit next time!");
				sc.close();
				System.exit(-1);
			}else {
				Tofu tofu = mystore.sell(type);
				if(tofu != null) {
					System.out.println("we have "+tofu.name +" tofu");
				}else {
					System.out.println("Sorry! The "+type +" tofu has been sold-out!");
				}
			}
		}
	}
}
