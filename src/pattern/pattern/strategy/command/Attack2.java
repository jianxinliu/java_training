package pattern.pattern.strategy.command;

import pattern.pattern.strategy.Role;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 8:57:00 PM
 *
 */
public class Attack2 implements Command{
	
	private final static String NAME="2";
	private Role hero;
	
	public Attack2(Role role) {
		this.hero = role;
	}
	@Override
	public void execute() {
		hero.attack2();
	}

}
