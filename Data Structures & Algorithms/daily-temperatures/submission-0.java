class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int prevIndx = st.pop();
                res[prevIndx] = i - prevIndx;
            }
            st.push(i);
        }
        return res;
    }
}
