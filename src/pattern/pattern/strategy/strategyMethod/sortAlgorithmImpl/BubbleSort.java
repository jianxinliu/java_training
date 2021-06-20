package pattern.pattern.strategy.strategyMethod.sortAlgorithmImpl;

import pattern.pattern.strategy.strategyMethod.SortAlgorithm;

import java.util.List;

/**
 * @author jianxinliu
 * @date 2021/06/20 11:25
 */
public class BubbleSort implements SortAlgorithm {
    @Override
    public void sort(List<Integer> arr) {
        System.out.println("bubble sort....");
        arr.sort((a, b) -> a - b);
    }
}
