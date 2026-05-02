class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();

        int l=0,r=0;

        while(r < nums.length){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.pollLast();
            }

            q.offerLast(r);

            if(l>q.peekFirst()){
                q.pollFirst();
            }

            if((r+1)>=k){
                output.add(nums[q.peekFirst()]);
                l++;
            }
            r++;

            
        }
        int[] res = new int[output.size()];
            for(int i=0; i<output.size(); i++){
                res[i] = output.get(i);
            }
        return res;
    }
}
