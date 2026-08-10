class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthestIndex =0;

        for(int i=0; i<n; i++){
            if(i>farthestIndex){
                return false;
            }
            farthestIndex = Math.max(farthestIndex, i+nums[i]);
        }
        return true;
    }
}
