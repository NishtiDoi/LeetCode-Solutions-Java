class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if (backtrack(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        // base + boundary checks go here
        if(index==word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) 
            return false;
        

        // mark visited[i][j] = true
        visited[i][j]=true;
        // recursively explore up, down, left, right
        boolean found=  backtrack(board, word, i+1, j, index+1, visited) ||
                        backtrack(board, word, i, j+1, index+1, visited) ||
                        backtrack(board, word, i, j-1, index+1, visited) ||
                        backtrack(board, word, i-1, j, index+1, visited);
        // unmark visited[i][j] before returning (backtrack step)
        visited[i][j]=false;

        // return true if full word is found
        
        return found;
    }
}
