package pattern.pattern.strategy.roles.libai;

import pattern.pattern.strategy.attack.IAttack3;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 6:47:38 PM
 *
 */
public class NewLiBaiAttack3 implements IAttack3 {

	@Override
	public void attack3() {
		System.out.println("attack3 start");
		Base.hurt();
		Base.hurt();
		System.out.println("attack3 end");
	}

}
