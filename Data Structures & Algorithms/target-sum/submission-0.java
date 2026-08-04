class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num: nums){
            total += num;
        }

        if(total < Math.abs(target) || (total+target)%2!=0){
            return 0;
        }

        int subsum = (total+target)/2;
        int[] dp = new int[subsum+1];
        dp[0] = 1;

        for(int num: nums){
            for(int i=subsum; i>=num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[subsum];
    }
}
