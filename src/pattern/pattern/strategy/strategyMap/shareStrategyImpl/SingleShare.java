package pattern.pattern.strategy.strategyMap.shareStrategyImpl;

import pattern.pattern.strategy.strategyMap.ShareStrategy;

/**
 * @author jianxinliu
 * @date 2021/06/20 11:03
 */
public class SingleShare implements ShareStrategy {
    @Override
    public void share(String params) {
        System.out.println("Share single item: " + params);
    }
}
