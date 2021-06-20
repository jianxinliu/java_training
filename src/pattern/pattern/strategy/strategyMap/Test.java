package pattern.pattern.strategy.strategyMap;

/**
 * 使用 Map 实现策略模式
 * @author jianxinliu
 * @date 2021/06/20 11:10
 */
public class Test {
    public static void main(String[] args) {
        ShareStrategy shareStrategy = ShareFactory.getShareStrategy(ShareType.SINGLE);
        shareStrategy.share("my photo");

        shareStrategy = ShareFactory.getShareStrategy(ShareType.MULTIPLE);
        shareStrategy.share("my photos");
    }
}
