class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jump=0;
        int currInd=0;
        int farthestInd=0;

        for(int i=0; i<n-1; i++){
            farthestInd = Math.max(farthestInd, i+nums[i]);

            if(i==currInd){
                jump++;
                currInd = farthestInd;
            }
        }
        return jump;
    }
}
