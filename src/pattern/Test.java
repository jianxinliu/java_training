package pattern;

import java.util.List;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 7:18:12 PM
 *
 */
public class Test {

	public static void main(String[] args) {
		ReqType req = ReqType.ADD;
		List<ReqType> list = req.list();
		for(ReqType e:list) {
			System.out.println(e.getName()+e.getType());
		}
	}
}
