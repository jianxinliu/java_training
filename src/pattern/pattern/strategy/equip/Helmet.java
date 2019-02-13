package pattern.pattern.strategy.equip;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 6:50:05 PM
 *
 */
public class Helmet extends AbstractEquip {

	private final static String NAME = "Helmet";
	private final static int ATTACK_VALUE = 15;
	private final static int DEFENCE_VALUE = 0;
	
	public Helmet() {
		name = NAME;
		attack = ATTACK_VALUE;
		defence = DEFENCE_VALUE;
	}
}
