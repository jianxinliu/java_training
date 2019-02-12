package pattern.pattern.strategy;

import pattern.pattern.strategy.attack.IAttack1;
import pattern.pattern.strategy.attack.IAttack2;
import pattern.pattern.strategy.attack.IAttack3;
import pattern.pattern.strategy.attack.INormalAttack;

/**
 *
 * @author ljx
 * @Date Feb 11, 2019 5:19:27 PM
 *
 */
public abstract class Role {

	protected String name;
	protected IAttack1 attack1;
	protected IAttack2 attack2;
	protected IAttack3 attack3;
	protected INormalAttack normalAttack;
	
	public Role setAttack1(IAttack1 attack1) {
		this.attack1 = attack1;
		return this;
	}
	
	public Role setAttack2(IAttack2 attack2) {
		this.attack2 = attack2;
		return this;
	}
	
	public Role setAttack3(IAttack3 attack3) {
		this.attack3 = attack3;
		return this;
	}
	
	public Role setNormalAttack(INormalAttack normalAttack) {
		this.normalAttack = normalAttack;
		return this;
	}
	
	public void attack1() {
		attack1.attack1();
	}
	
	public void attack2() {
		attack2.attack2();
	}
	
	public void attack3() {
		attack3.attack3();
	}
	
	public void normalAttack() {
		normalAttack.normalAttack();
	}
	
	public Role(String name) {
		this.name = name;
	}
}
