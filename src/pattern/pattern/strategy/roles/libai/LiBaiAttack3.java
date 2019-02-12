package pattern.pattern.strategy.roles.libai;

import pattern.pattern.strategy.attack.IAttack3;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 6:37:24 PM
 *
 */
public class LiBaiAttack3 implements IAttack3 {

	@Override
	public void attack3() {
		if(Base.dancing()) {
			System.out.println("attack3 start");
			Base.hurt();
			Base.hurt();
			Base.hurt();
			System.out.println("attack3 end");
			Base.attack3ActiveTimes = 4;// restore the active times
		}
	}
}
