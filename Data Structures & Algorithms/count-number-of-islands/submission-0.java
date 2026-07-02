class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int isIsland =0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    bfs(grid,vis,i,j);
                    isIsland++;
                }
            }
        }
        return isIsland;
    }

    private void bfs(char[][] grid, boolean[][] vis, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        vis[r][c] = true;

        int[][] directions = {
            {1,0},{-1,0},{0,1}, {0,-1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int[] dir: directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]=='1' && !vis[nr][nc]){
                    q.offer(new int[]{nr,nc});
                    vis[nr][nc] = true;
                }
            }
        }
    }
}
