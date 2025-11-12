/*
Approach:
Use backtracking to explore all possible combinations of numbers that sum up to the target.
At each step, choose a candidate number and recursively try to reach the target by reducing the remaining sum.
If the sum becomes zero, store the current combination.
If it becomes negative, backtrack.
Each number can be reused, so we do not increment the index after choosing it.
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i =start; i<candidates.length; i++){
            if(i>start && candidates[i]==candidates[i-1]) 
                continue;
            if(target<candidates[i])
                break;
                
            comb.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, comb, res);
            comb.remove(comb.size()-1);
        }
    }
}
