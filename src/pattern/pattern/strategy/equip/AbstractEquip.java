package pattern.pattern.strategy.equip;

/**
 *
 * @author ljx
 * @Date Feb 12, 2019 6:35:05 PM
 *
 */
public abstract class AbstractEquip{
	
	protected String name = "";
	protected int attack = 0;
	protected int defence = 0;
	
	/**
	 * get equipment name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	public int getAttackValue() {
		return attack;
	}
	
	public int getDefenceValue() {
		return defence;
	}
}
