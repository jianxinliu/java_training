package pattern.pattern.strategy;

import pattern.pattern.strategy.roles.libai.RoleLiBai;

public class RoleTest {

	public static void main(String[] args) {
		RoleLiBai libai = new RoleLiBai();
		libai.attack1();
		libai.attack2();
		libai.attack3();
		
		libai.attack1();
		libai.attack1();
		
		libai.normalAttack();
		libai.normalAttack();
		libai.normalAttack();
		libai.normalAttack();
		libai.attack3();
	}
}
