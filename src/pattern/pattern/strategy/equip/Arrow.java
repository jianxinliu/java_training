package pattern.pattern.strategy.equip;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 6:49:08 PM
 *
 */
public class Arrow extends AbstractEquip {

	private final static String NAME = "Arrow";
	private final static int ATTACK_VALUE = 20;
	private final static int DEFENCE_VALUE = 0;
	
	public Arrow() {
		name = NAME;
		attack = ATTACK_VALUE;
		defence = DEFENCE_VALUE;
	}
}
