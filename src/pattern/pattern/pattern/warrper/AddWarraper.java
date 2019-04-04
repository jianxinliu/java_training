package pattern.pattern.pattern.warrper;

import java.util.ArrayList;
import java.util.List;

import pattern.pattern.pattern.ActorWarrper;
import pattern.pattern.pattern.BaseReq;
import pattern.pattern.pattern.BaseResp;
import pattern.pattern.pattern.IActor;
import pattern.pattern.pattern.actor.AddActor;
import pattern.pattern.pattern.actor.NextActor;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 7:31:59 PM
 *
 */
public class AddWarraper implements ActorWarrper {

	@Override
	public List<IActor<BaseReq<Object>, BaseResp<Object>>> getActors() {
		List<IActor<BaseReq<Object>, BaseResp<Object>>> ret = new ArrayList<>();
		
		ret.add(new AddActor());
		ret.add(new NextActor());
		return ret;
	}

}
