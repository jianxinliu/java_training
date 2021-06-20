package pattern.pattern.strategy.strategyMethod;

import pattern.pattern.strategy.strategyMethod.sortAlgorithmImpl.BubbleSort;
import pattern.pattern.strategy.strategyMethod.sortAlgorithmImpl.QuickSort;

import java.util.Arrays;
import java.util.List;

/**
 * 使用函数式思想实现策略模式
 * @author jianxinliu
 * @date 2021/06/20 11:21
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 6, 7, 8, 56, 7);

        new QuickSort().sort(arr);
        System.out.println(arr);

        new BubbleSort().sort(arr);
        System.out.println(arr);
    }
}
