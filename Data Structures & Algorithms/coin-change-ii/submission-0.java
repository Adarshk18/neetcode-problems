class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount+1];
        prev[0] = 1;

        for(int i=n-1; i>=0; i--){
            int[] curr = new int[amount+1];
            curr[0] = 1;

            for(int t=1; t<=amount; t++){
                int notPick = prev[t];
                int pick=0;

                if(coins[i]<=t){
                    pick = curr[t-coins[i]];
                }
                curr[t] = notPick + pick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}
