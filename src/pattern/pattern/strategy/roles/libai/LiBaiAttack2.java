package pattern.pattern.strategy.roles.libai;

import pattern.pattern.strategy.attack.IAttack2;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 6:36:01 PM
 *
 */
public class LiBaiAttack2 implements IAttack2 {

	@Override
	public void attack2() {
		Base.circle();
		Base.hurt();
	}
}
