class Solution {
    private int rows,cols;
    private char[][] board;

    public void solve(char[][] board) {
        if(board == null || board.length==0){
            return;
        }

        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for(int r=0; r<rows; r++){
            if(board[r][0]=='O'){
                dfs(r,0);
            }

            if(board[r][cols-1]=='O'){
                dfs(r,cols-1);
            }
        }

        for(int c=0; c<cols; c++){
            if(board[0][c]=='O'){
                dfs(0,c);
            }

            if(board[rows-1][c]=='O'){
                dfs(rows-1,c);
            }
        }

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c]=='T'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c){
        if(r<0 || r>=rows || c<0 || c>=cols || board[r][c]!='O'){
            return;
        }

        board[r][c] = 'T';
        dfs(r+1,c);
        dfs(r-1,c);
        dfs(r,c+1);
        dfs(r,c-1);
    }
    
}
