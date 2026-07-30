class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return func(0,-1,nums,n,dp);
    }

    private int func(int indx, int prevIndx, int[] nums, int n, int[][] dp){
        if(indx==n){
            return 0;
        }

        if(dp[indx][prevIndx+1]!=-1) return dp[indx][prevIndx+1];

        int len = 0 + func(indx+1,prevIndx,nums, n,dp);
        if(prevIndx==-1 || nums[indx] > nums[prevIndx]){
            len = Math.max(len,1+func(indx+1,indx,nums,n,dp));
        }
        return dp[indx][prevIndx+1] =len;
    }
}
