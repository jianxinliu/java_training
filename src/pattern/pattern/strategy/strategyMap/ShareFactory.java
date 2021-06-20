package pattern.pattern.strategy.strategyMap;

import pattern.pattern.strategy.strategyMap.shareStrategyImpl.MultipleShare;
import pattern.pattern.strategy.strategyMap.shareStrategyImpl.SingleShare;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianxinliu
 * @date 2021/06/20 11:05
 */
public class ShareFactory {

    private final static Map<ShareType, ShareStrategy> STRATEGIES = new HashMap<>();

    static {
        STRATEGIES.put(ShareType.SINGLE, new SingleShare());
        STRATEGIES.put(ShareType.MULTIPLE, new MultipleShare());
    }

    static ShareStrategy getShareStrategy(ShareType type) {
        if (type == null) {
            throw new IllegalArgumentException("type should not be null");
        }
        return STRATEGIES.get(type);
    }
}
