class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int total=0;
        for(int num: nums){
            total += num;
        }

        if(total%2!=0) return false;

        int target = total/2;
        
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num: nums){
            for(int j=target; j>=num; j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        return dp[target];

    }
    // private boolean func(int indx, int target, int[] nums, Boolean[][] dp){
    //     if(target==0) return true;

    //     if(indx==nums.length || target <0) return false;

    //     if(dp[indx][target]!=null) return dp[indx][target];

    //     boolean notPick = func(indx+1, target, nums, dp);
    //     boolean pick = false;
    //     if(nums[indx]<=target){
    //         pick = func(indx+1,target-nums[indx], nums, dp);
    //     }

    //     return dp[indx][target] = pick || notPick ;
    // }
}
