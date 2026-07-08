class Solution {
    private int rows, cols;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int c=0; c<cols; c++){
            dfs(0,c,pac,heights[0][c]);
            dfs(rows-1,c,atl, heights[rows-1][c]);
        }
        
        for(int r=0; r<rows; r++){
            dfs(r,0,pac,heights[r][0]);
            dfs(r,cols-1,atl, heights[r][cols-1]);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;

    }

    private void dfs(int r, int c, boolean[][] vis, int prevHeight){
        if(r <0 || r>=rows || c<0 || c>=cols || vis[r][c] || heights[r][c] < prevHeight){
            return;
        }

        vis[r][c] = true;
        dfs(r+1,c,vis, heights[r][c]);
        dfs(r-1,c,vis, heights[r][c]);
        dfs(r,c+1,vis, heights[r][c]);
        dfs(r,c-1,vis, heights[r][c]);
    }
}
