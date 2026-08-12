class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int  n =triplets.length;

        boolean first = false;
        boolean second = false;
        boolean third = false;

        for(int i=0; i<n; i++){
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2]>target[2]) continue;

            if(triplets[i][0] == target[0]) first = true;
            if(triplets[i][1] == target[1]) second = true;
            if(triplets[i][2] == target[2]) third = true; 
        }

        return first && second && third;
    }
}
