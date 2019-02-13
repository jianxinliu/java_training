package pattern.pattern.strategy.equip.decorator;

import pattern.pattern.strategy.Role;
import pattern.pattern.strategy.equip.Arrow;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 9:11:16 PM
 *
 */
public class ArrowDecorator extends AbstractEquipDecorator{

	private static Arrow arrow = new Arrow();
	/**
	 * @param hero
	 */
	public ArrowDecorator(Role hero) {
		super(hero,arrow);
	}

}
