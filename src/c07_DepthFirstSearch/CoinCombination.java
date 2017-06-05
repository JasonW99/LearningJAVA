package c07_DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class CoinCombination {
    public List<List<Integer>> solve(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subResult = new ArrayList<Integer>();
        combinationRecur(target, coins, result, subResult, 0);
        return result;
    }

    private void combinationRecur(int target, int[] coins, List<List<Integer>> result, List<Integer> subResult, int level) {
        if (level == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                subResult.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(subResult));
                subResult.remove(subResult.size() - 1);
            }
            return;
        }
        for (int i = 0; i <= target / coins[level]; i++) {
            subResult.add(i);
            combinationRecur(target - i * coins[level], coins, result, subResult, level + 1);
            subResult.remove(subResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        CoinCombination test = new CoinCombination();
        List<List<Integer>> result = test.solve(4, new int[] {2, 1});
        for (List<Integer> sub : result) {
            String subresult = "";
            for (Integer i : sub) {
                subresult += i + "\t";
            }
            System.out.println(subresult);
        }
    }
}





