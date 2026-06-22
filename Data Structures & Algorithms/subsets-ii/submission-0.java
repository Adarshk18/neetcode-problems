class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
       

        dfs(0,nums,res,new ArrayList<>());
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> sublist){
        if(i==nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(nums[i]);
        dfs(i+1,nums,res,sublist);

        sublist.remove(sublist.size()-1);

        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }

        dfs(i+1,nums,res, sublist);
    }
}
