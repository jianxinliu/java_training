package pattern.pattern.strategy.roles.libai;

import pattern.pattern.strategy.Role;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 11:30:38 PM
 *
 */
public class StrongerLiBai extends Role{

	private static final String NAME = Base.NAME;
	private static final int attack = Base.ATTACK;
	private static final int defense = Base.DEFENSE;
	
	public StrongerLiBai() {
		super(NAME);
		this.setAttack1(new LiBaiAttack1())
			.setAttack2(new LiBaiAttack2())
			.setAttack3(new LiBaiAttack3())
			.setNormalAttack(new LiBaiNormalAttack())
			.setAttack_value(attack)
			.setDefense_value(defense);
	}

	// decorator(wrapper)
	@Override
	public int getAttack_value() {
		return super.getAttack_value() + 100;
	}

	@Override
	public int getDefense_value() {
		return super.getDefense_value() + 100;
	}
	
	
}
