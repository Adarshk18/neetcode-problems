class Solution {

    private List<List<String>> res = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> posDi = new HashSet<>();
    private Set<Integer> negDi = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        backtrack(0,n,board);
        return res;
    }

    private void backtrack(int row, int n, char[][] board){
        if(row==n){
            List<String> copy = new ArrayList<>();
            for(char[] r: board){
                copy.add(new String(r));
            }
            res.add(copy);
            return;
        }

        for(int col=0; col<n; col++){

            if(cols.contains(col) || posDi.contains(row+col) || negDi.contains(row-col)){
                continue;
            }


            cols.add(col);
            posDi.add(row+col);
            negDi.add(row-col);
            board[row][col] = 'Q';

            backtrack(row+1,n,board);

            cols.remove(col);
            posDi.remove(row+col);
            negDi.remove(row-col);
            board[row][col] = '.';
        }
    }
}
