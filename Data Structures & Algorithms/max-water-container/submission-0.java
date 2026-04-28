class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l =0, r = n-1;
        int res = 0;
        while(l<r){
            int area = (r-l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, area);

            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
