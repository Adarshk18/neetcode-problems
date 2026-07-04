class Solution {
    private int rows, cols;
    private boolean[][] vis;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        vis = new boolean[rows][cols];

        int area = 0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                area = Math.max(area, dfs(grid,r,c));
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]==0 || vis[r][c]){
            return 0;
        }

        vis[r][c] = true;
        return 1+ dfs(grid,r+1,c) + dfs(grid, r-1,c) + dfs(grid,r,c+1) + dfs(grid, r,c-1);
    }
}
