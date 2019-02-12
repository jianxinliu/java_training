package pattern.application.calculator;

/**
 *
 * @author ljx
 * @Date Feb 10, 2019 7:18:25 PM
 *
 */
public interface Operation<T> {

	Result<T> operate();
}
