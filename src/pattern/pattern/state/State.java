package pattern.pattern.state;

/**
 *
 * @author ljx
 * @Date Feb 13, 2019 1:07:44 AM
 *
 */
public interface State {
	/**
	 * 放钱
	 */
	public void insertMoney();
	/**
	 * 退钱
	 */
	public void backMoney();
	/**
	 * 转动曲柄
	 */
	public void turnCrank();
	/**
	 * 出商品
	 */
	public void dispense();

}
