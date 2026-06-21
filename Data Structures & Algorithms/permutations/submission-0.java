class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for(int n: nums){
            List<List<Integer>> newPerms = new ArrayList<>();

            for(List<Integer> p: perms){
                for(int i=0; i<=p.size(); i++){
                    List<Integer> pcopy = new ArrayList<>(p);
                    pcopy.add(i,n);
                    newPerms.add(pcopy);
                }
            }
            perms = newPerms;
        }
        return perms;
    }
}
