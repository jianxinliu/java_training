package pattern.pattern.strategy;

import java.util.Scanner;

import pattern.pattern.strategy.command.Attack1;
import pattern.pattern.strategy.command.Attack2;
import pattern.pattern.strategy.command.Attack3;
import pattern.pattern.strategy.command.Command;
import pattern.pattern.strategy.command.NormalAttack;
import pattern.pattern.strategy.roles.HerosUtil;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 9:04:41 PM
 *
 */
public class CommandPanel {
	
	private static Role currentHero = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("which hero do you want?");
		String heroWant = sc.nextLine();
		currentHero = HerosUtil.getHeros("roles/heros.properties").get(heroWant);
		
		while(sc.hasNext()) {
			String cmd = sc.nextLine();
			if("q".equals(cmd)) {
				sc.close();
				System.exit(-1);
			}else {
				Command command = matchCommand(cmd);
				command.execute();
			}
		}
	}
	
	public static Command matchCommand(String cmd) {
		Command ret = null;
		switch(cmd) {
			case "1":{
				ret = new Attack1(currentHero);
				break;
			}
			case "2":{
				ret = new Attack2(currentHero);
				break;
			}
			case "3":{
				ret = new Attack3(currentHero);
				break;
			}
			case "A":{
				ret = new NormalAttack(currentHero);
				break;
			}
			default:{
				ret = new NormalAttack(currentHero);
			}
		}
		return ret;
	}
}
