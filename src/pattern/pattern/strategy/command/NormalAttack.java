package pattern.pattern.strategy.command;

import pattern.pattern.strategy.Role;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 9:03:27 PM
 *
 */
public class NormalAttack implements Command {

	private final static String NAME="A";
	private Role hero;
	
	public NormalAttack(Role role) {
		this.hero = role;
	}
	@Override
	public void execute() {
		hero.normalAttack();
	}

}
