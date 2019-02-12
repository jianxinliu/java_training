package pattern.actor;

import java.util.Map;

import pattern.BaseReq;
import pattern.BaseResp;
import pattern.IActor;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 7:55:20 PM
 *
 */
public class AddActor implements IActor<BaseReq,BaseResp>{

	/* 
	 * 
	 */
	@Override
	public BaseResp preHandle(BaseReq req, Integer reqType, Map<String, Object> params) {
		return null;
	}

	/* 
	 * 
	 */
	@Override
	public BaseResp execute(BaseReq req, Integer reqType, Map<String, Object> params) {
		return null;
	}

	/* 
	 * 
	 */
	@Override
	public BaseResp afterHandle(BaseReq req, Integer reqType, Map<String, Object> params) {
		return null;
	}

}
