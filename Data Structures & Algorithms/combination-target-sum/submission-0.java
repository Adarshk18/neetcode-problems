class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(0,nums,target,new ArrayList<>(),0,res);
        return res;

    }

    private void dfs(int i, int[] candidates, int target, List<Integer> curr, int total, List<List<Integer>> res){
        if( total == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i>=candidates.length || total > target){
            return;
        }

        curr.add(candidates[i]);
        dfs(i, candidates, target, curr, total+candidates[i], res);

        curr.remove(curr.size()-1);

        dfs(i+1,candidates,target,curr,total,res);
    }
}
