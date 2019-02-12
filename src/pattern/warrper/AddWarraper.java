package pattern.warrper;

import java.util.ArrayList;
import java.util.List;

import pattern.ActorWarrper;
import pattern.BaseReq;
import pattern.BaseResp;
import pattern.IActor;
import pattern.actor.AddActor;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 7:31:59 PM
 *
 */
public class AddWarraper implements ActorWarrper {

	@Override
	public List<IActor<BaseReq, BaseResp>> getActors() {
		List<IActor<BaseReq, BaseResp>> ret = new ArrayList<>();
		
		ret.add(new AddActor());
		
		return ret;
	}

}
