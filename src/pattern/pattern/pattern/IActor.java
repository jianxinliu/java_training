package pattern.pattern.pattern;

import java.util.Map;

/**
 * 行为
 * @author ljx
 * @Date Jan 22, 2019 10:37:40 AM
 *
 */
public interface IActor<Req extends BaseReq<Object>,Resp extends BaseResp<Object>> {
	public default boolean pass() {
		return true;
	}
	public default BaseResp<Object> preHandle(BaseReq<Object> req,Integer reqType,Map<String,Object> params) {
		return new BaseResp<Object>("00","success",null);
	}
	
	public BaseResp<Object> execute(BaseReq<Object> req,Integer reqType,Map<String,Object> params);
	
	public default BaseResp<Object> afterHandle(BaseReq<Object> req,Integer reqType,Map<String,Object> params) {
		return new BaseResp<Object>("00","success",null);
	}
}
