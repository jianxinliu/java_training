package pattern;

import java.util.Map;

/**
 * 行为
 * @author ljx
 * @Date Jan 22, 2019 10:37:40 AM
 *
 */
public interface IActor<Req extends BaseReq,Resp extends BaseResp> {
	public default boolean pass() {
		return true;
	}
	public Resp preHandle(Req req,Integer reqType,Map<String,Object> params);
	
	public Resp execute(Req req,Integer reqType,Map<String,Object> params);
	
	public Resp afterHandle(Req req,Integer reqType,Map<String,Object> params);
}
