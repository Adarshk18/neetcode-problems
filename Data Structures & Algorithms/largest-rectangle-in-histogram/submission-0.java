class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;
        Stack<int[]> st = new Stack<>();

        for(int i=0; i<n; i++){
            int start = i;

            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int[] top = st.pop();
                int indx = top[0];
                int height = top[1];

                maxArea = Math.max(maxArea, height*(i-indx));
                start = indx;
            }
            st.push(new int[]{start, heights[i]});
        }

        while(!st.isEmpty()){
            int[]top = st.pop();
            int indx = top[0];
            int height = top[1];

            maxArea = Math.max(maxArea, height*(n-indx));
        }
        return maxArea;
    }
}
