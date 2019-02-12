package pattern;

import java.util.List;

/**
 *
 * @author ljx
 * @Date Jan 22, 2019 3:41:56 PM
 *
 */
public interface ActorWarrper {

	List<IActor<BaseReq,BaseResp>> getActors();
}
