class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();

        dfs(0,nums,res,sublist);
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> sublist){
        if(i>=nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }

        sublist.add(nums[i]);
        dfs(i+1,nums,res,sublist);

        sublist.remove(sublist.size()-1);
        dfs(i+1,nums, res, sublist);
    }
}
