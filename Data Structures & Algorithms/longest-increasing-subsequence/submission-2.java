class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size =0;

        for(int num: nums){
            int left =0, right =size;

            while(left<right){
                int mid = left + (right-left)/2;
                if(tails[mid]<num){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            tails[left] = num;
            if(left==size){
                size++;
            }
        }
        return size;
    }

    // private int func(int indx, int prevIndx, int[] nums, int n, int[][] dp){
    //     if(indx==n){
    //         return 0;
    //     }

    //     if(dp[indx][prevIndx+1]!=-1) return dp[indx][prevIndx+1];

    //     int len = 0 + func(indx+1,prevIndx,nums, n,dp);
    //     if(prevIndx==-1 || nums[indx] > nums[prevIndx]){
    //         len = Math.max(len,1+func(indx+1,indx,nums,n,dp));
    //     }
    //     return dp[indx][prevIndx+1] =len;
    // }
}
