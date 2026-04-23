class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num: nums){
            cnt.put(num, cnt.getOrDefault(num,0)+1);
        }

        List<Integer>[] freq = new ArrayList[nums.length+1];
        for(int i=0; i<freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(int num: cnt.keySet()){
            int f = cnt.get(num);
            freq[f].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=freq.length-1; i>=0; i--){
            for(int num: freq[i]){
                res.add(num);
                if(res.size()==k){
                    return res.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return new int[]{};
    }
}
