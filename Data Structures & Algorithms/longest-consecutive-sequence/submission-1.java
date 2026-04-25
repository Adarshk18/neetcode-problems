class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num: nums){
            st.add(num);
        }

        int longest = 0;
        for(int num: st){
            if(!st.contains(num-1)){
                int curr = num;
                int length = 1;

                while(st.contains(curr+1)){
                    curr++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
  