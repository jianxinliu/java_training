package pattern.pattern.strategy.roles.libai;

import pattern.pattern.strategy.attack.INormalAttack;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 6:38:51 PM
 *
 */
public class LiBaiNormalAttack implements INormalAttack {

	@Override
	public void normalAttack() {
		Base.hurt();
		Base.attack3ActiveTimes--;
	}
}
