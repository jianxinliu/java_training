package pattern.pattern.strategy.equip;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 6:38:17 PM
 *
 */
public class Shoe extends AbstractEquip{
	
	private final static String NAME = "defence shoe";
	private final static int ATTACK_VALUE = 0;
	private final static int DEFENCE_VALUE = 10;
	
	public Shoe() {
		name = NAME;
		attack = ATTACK_VALUE;
		defence = DEFENCE_VALUE;
	}
}
