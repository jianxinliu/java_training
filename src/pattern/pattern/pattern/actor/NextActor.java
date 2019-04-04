package pattern.pattern.pattern.actor;

import java.util.Map;

import pattern.pattern.pattern.BaseReq;
import pattern.pattern.pattern.BaseResp;
import pattern.pattern.pattern.IActor;

/**
 *
 * @author ljx
 * @Date Apr 4, 2019 1:39:14 AM
 *
 */
public class NextActor implements IActor<BaseReq<Object>,BaseResp<Object>> {


	@Override
	public BaseResp<Object> execute(BaseReq<Object> req, Integer reqType, Map<String, Object> params) {
		System.out.println(params.get("haha"));
		
		return null;
	}

}
