class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int prev2 = 0;

        for(int i=n-1; i>=0; i--){
            int pick = nums[i] + prev2;
            int notPick = prev;

            int curr = Math.max(pick,notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
