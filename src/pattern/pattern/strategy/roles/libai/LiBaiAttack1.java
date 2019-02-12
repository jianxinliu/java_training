package pattern.pattern.strategy.roles.libai;

import pattern.pattern.strategy.attack.IAttack1;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 6:30:17 PM
 *
 */
public class LiBaiAttack1 implements IAttack1 {

	@Override
	public void attack1() {
		if(Base.move())
			Base.hurt();
	}
}
