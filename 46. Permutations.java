

/*
Use backtracking to generate all orderings.

Track used elements with a boolean array.

At each step, pick any unused element and recurse.

When current list size equals array length, add it to result.

Backtrack by unmarking and removing the last chosen element.
*/
import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used elements

            used[i] = true;
            temp.add(nums[i]);

            backtrack(nums, temp, used, res);

            // backtrack step
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.permute(nums));
    }
}
