package pattern.pattern.strategy.strategyMethod.sortAlgorithmImpl;

import pattern.pattern.strategy.strategyMethod.SortAlgorithm;

import java.util.List;

/**
 * @author jianxinliu
 * @date 2021/06/20 11:23
 */
public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(List<Integer> arr) {
        System.out.println("quick sort....");
        arr.sort((a, b) -> a - b);
    }
}
