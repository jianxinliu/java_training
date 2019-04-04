package pattern.pattern.pattern.actor;

import java.util.Map;

import pattern.pattern.pattern.BaseReq;
import pattern.pattern.pattern.BaseResp;
import pattern.pattern.pattern.IActor;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 7:55:20 PM
 *
 */
public class AddActor implements IActor<BaseReq<Object>,BaseResp<Object>>{

	@Override
	public BaseResp<Object> execute(BaseReq<Object> req, Integer reqType, Map<String, Object> params) {
		params.put("haha", "123");
		BaseResp<Object> ret = new BaseResp<Object>("00","success",null);
		return ret;
	}
}
