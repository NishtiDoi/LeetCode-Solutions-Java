/*
Use backtracking to explore combinations that sum to target.

Sort input to allow pruning (if candidate > target → break).

Recurse with same index i to allow reuse of elements.

When target == 0, add current combination to result.

Backtrack after each recursive call by removing last element.
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;

            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}
