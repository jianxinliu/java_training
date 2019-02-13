package pattern.pattern.strategy.equip.decorator;

import pattern.pattern.strategy.Role;
import pattern.pattern.strategy.equip.AbstractEquip;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 7:31:55 PM
 *
 */
public abstract class AbstractEquipDecorator extends AbstractEquip{

	private Role role;
	private AbstractEquip equip;
	
	public AbstractEquipDecorator(Role hero,AbstractEquip equip) {
		this.role = hero;
		this.equip = equip;
		
	}
	
	public String getName() {
		return role.getName() +": "+ equip.getName();
	}
	
	public int getAttack_value() {
		return role.getAttack_value() + equip.getAttackValue();
	}
	
	public int getDefense_value() {
		return role.getDefense_value() + equip.getDefenceValue();
	}
}
