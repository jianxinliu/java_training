package pattern.pattern.strategy.strategyMap;

/**
 * 分享策略
 *
 * @author jianxinliu
 * @date 2021/06/20 11:00
 */
public interface ShareStrategy {
    /**
     * 不同分享策略的具体执行逻辑
     * @param params 具体参数
     */
    void share(String params);
}
