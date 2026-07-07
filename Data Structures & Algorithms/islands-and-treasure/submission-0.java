class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c]==0){
                    q.add(new int[]{r,c});
                }
            }
        }

        int[][] directions = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int[] dir: directions){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if(nr<0 || nr>=rows || nc<0 || nc>=cols || grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc] = grid[curr[0]][curr[1]]+1;
                q.add(new int[]{nr,nc});

            }
        }
    }
}
