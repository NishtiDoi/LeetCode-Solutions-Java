/*
Approach:
Use backtracking to build valid parentheses strings of length 2 * n.
At each step, add '(' if the count of open brackets is less than n,
and add ')' if the count of close brackets is less than open.
Continue until the string reaches the required length.
Store only balanced combinations.
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        backtrack(res, 0, 0, n, "");
        return res;
    }
    private void backtrack(List<String> res, int open, int close, int n, String curr){
        if(curr.length()==n*2){
            res.add(curr);
            return;
        }

        if(open<n) backtrack(res, open+1, close, n, curr + "(");
        if(close<open) backtrack(res, open, close+1, n, curr + ")");
    }
}
