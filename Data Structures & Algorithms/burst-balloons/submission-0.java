class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;

        for(int i=0; i<n; i++){
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(arr, 1,n,dp);
    }

    private int dfs(int[] nums, int l, int r, int[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];

        int maxCoins = 0;
        for(int i=l; i<=r; i++){
            int coins = nums[l-1] * nums[i] * nums[r+1];
            coins += dfs(nums, l, i-1, dp) + dfs(nums,i+1,r,dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        return dp[l][r] = maxCoins;
    }
}
