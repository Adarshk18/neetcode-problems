class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n%groupSize!=0){
            return false;
        }

        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        for(int card: hand){
            cnt.put(card, cnt.getOrDefault(card,0)+1);
        }

        while(!cnt.isEmpty()){
            int start = cnt.firstKey();

            for(int i=0; i<groupSize; i++){
                int curr = start +i;

                if(!cnt.containsKey(curr)){
                    return false;
                }

                cnt.put(curr, cnt.get(curr)-1);

                if(cnt.get(curr)==0){
                    cnt.remove(curr);
                }
            }
        }
        return true;
    }
}
