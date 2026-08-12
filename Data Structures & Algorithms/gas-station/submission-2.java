class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totGas =0;
        int totCost =0;

        for(int i=0; i<n; i++){
            totGas += gas[i];
            totCost += cost[i];
        }
        if(totGas<totCost){
            return -1;
        }

        int total=0;
        int res =0;
        for(int i=0; i<n; i++){
            total += gas[i] - cost[i];

            if(total <0){
                total=0;
                res = i+1;
            }
        }
        return res;
    }
}
