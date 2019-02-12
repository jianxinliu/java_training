package pattern.pattern.strategy.command;

import pattern.pattern.strategy.Role;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 8:57:00 PM
 *
 */
public class Attack3 implements Command{
	
	private final static String NAME="3";
	private Role hero;
	
	public Attack3(Role role) {
		this.hero = role;
	}
	@Override
	public void execute() {
		hero.attack3();
	}

}
