class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
       
        Set<Integer> st = new HashSet<>();
        for(int num: nums){
            if(st.contains(num)){
                return true;
            }
            st.add(num);
        }
        return false;
    }
}