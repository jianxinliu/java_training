package pattern.pattern.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pattern.pattern.pattern.warrper.AddWarraper;

/**
 * 行为执行器
 * @author ljx
 * @Date Jan 22, 2019 11:05:51 AM
 *
 */
public class ActorExecutor {

	private static List<IActor<BaseReq<Object>,BaseResp<Object>>> actors = new ArrayList<>();
	
	private static Map<Integer,Object> map = new HashMap<Integer,Object>();
	
//	static {
//		actors.add(new AddActor());
//		List<ReqType> ls = ReqType.list();
//		// initial map,map structure just like <type number,type name>
//		for(int i = 0 ; i < ls.size(); i++) {
//			map.put(ls.get(i).getType(), actors.get(i));
//		}
//	}
	
	public BaseResp<Object> receiveRequest(BaseReq<Object> reqDto, int reqType, Class<?> c){
		List<IActor<BaseReq<Object>, BaseResp<Object>>> actors = getActors(reqType);
		BaseResp<Object> execute = execute(reqDto,actors,reqType);
		return execute;
	}
	
	private List<IActor<BaseReq<Object>,BaseResp<Object>>> getActors(int reqType) {
		List<IActor<BaseReq<Object>,BaseResp<Object>>> ret = null;
		if(reqType == ReqType.ADD.getType()) {
			ret = new AddWarraper().getActors();
		}
		return ret;
	}
	
	/**
	 * 执行一系列行为
	 * @param reqDto
	 * @param actors
	 * @param reqType
	 * @return
	 */
	private BaseResp<Object> execute(BaseReq<Object> reqDto,List<IActor<BaseReq<Object>, BaseResp<Object>>> actors,int reqType) {
		BaseResp<Object> ret = null;
		// 系列共享
		Map<String,Object> params = new HashMap<String,Object>();
		boolean execSuccess = true;
		try {
			for(IActor<BaseReq<Object>, BaseResp<Object>> actor : actors) {
				
				// prehandle
				BaseResp<Object> preHandle = actor.preHandle(reqDto, reqType, params);
				if(preHandle.getCode() != "00") {
					ret  = new BaseResp<Object>("EE","error",null);
					execSuccess = false;
				}else {
					ret = new BaseResp<Object>(preHandle.getCode(),preHandle.getMsg(),preHandle.getData());
				}
				
				// execute
				BaseResp<Object> execute = actor.execute(reqDto, reqType, params);
				if(execute.getCode() != "00") {
					ret  = new BaseResp<Object>("EE","error",null);
					execSuccess = false;
				}else {
					ret = new BaseResp<Object>(preHandle.getCode(),preHandle.getMsg(),preHandle.getData());
				}
				
				// afterHandle
				BaseResp<Object> afterHandle = actor.afterHandle(reqDto, reqType, params);
				if(afterHandle.getCode() != "00") {
					ret  = new BaseResp<Object>("EE","error",null);
					execSuccess = false;
				}else {
					ret = new BaseResp<Object>(preHandle.getCode(),preHandle.getMsg(),preHandle.getData());
				}
				
				if(!execSuccess) {
					break;
				}
			}
		}catch(Exception e) {
			ret = new BaseResp<Object>("EE","error",null);
		}
		return ret;
	}

	
}
