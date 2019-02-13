package pattern.pattern.strategy;

import pattern.pattern.strategy.equip.decorator.ArrowDecorator;
import pattern.pattern.strategy.roles.libai.RoleLiBai;
import pattern.pattern.strategy.roles.libai.StrongerLiBai;

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
		
		ArrowDecorator arrowDecorator = new ArrowDecorator(libai);
		System.out.println(arrowDecorator.getAttack_value());
		System.out.println(arrowDecorator.getName());
		System.out.println(arrowDecorator.getDefense_value());
		
		StrongerLiBai slb = new StrongerLiBai();
		System.out.println(slb.getAttack_value());
	}
}
