package pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 行为执行器
 * @author ljx
 * @Date Jan 22, 2019 11:05:51 AM
 *
 */
public class ActorExecutor {

	private List<IActor<BaseReq,BaseResp>> actors = null;
	private List<ReqType> types = new ArrayList<ReqType>();
	
	private static Map<Integer,Object> map = new HashMap<Integer,Object>();
	
	static {
		List<ReqType> ls = ReqType.list();
		// initial map,map structure just like <type number,type name>
		for(int i = 0 ; i < ls.size(); i++) {
			map.put(ls.get(i).getType(), ls.get(i).getName());
		}
	}
	
	public <T extends BaseResp> BaseResp receiveRequest(BaseReq reqDto, int reqType, Class<T> c){
		List<IActor<BaseReq, BaseResp>> actors = getActors(reqType);
		BaseResp execute = execute(reqDto,actors,reqType);
		return execute;
	}
	
	private List<IActor<BaseReq,BaseResp>> getActors(int reqType) {
		return (List<IActor<BaseReq, BaseResp>>) map.get(reqType);
	}
	
	private BaseResp execute(BaseReq reqDto,List<IActor<BaseReq, BaseResp>> actors,int reqType) {
		
		return null;
	}
}
