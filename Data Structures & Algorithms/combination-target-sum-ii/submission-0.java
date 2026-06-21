class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0,new ArrayList<>(), 0, candidates, target, res);
        return res;
    }

    private void dfs(int i, List<Integer> curr, int total, int[] candidates, int target, List<List<Integer>> res){
        if(total == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(total > target || i == candidates.length){
            return;
        }

        curr.add(candidates[i]);
        dfs(i+1,curr, total + candidates[i], candidates, target, res);

        curr.remove(curr.size()-1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }

        dfs(i+1,curr, total, candidates, target, res);
    }
}
