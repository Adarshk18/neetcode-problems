class Solution {
    private int claculateHrs(int[] piles, int speed){
        int totalH = 0;
        for(int bananas: piles){
            totalH += (int)Math.ceil((double)bananas/speed);
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile =Arrays.stream(piles).max().getAsInt();

        int l=1, high=maxPile;
        int ans = maxPile;
        while(l<=high){
            int mid = (l+high)/2;

            int totalH = claculateHrs(piles,mid);
            if(totalH<=h){
                ans = mid;
                high = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
