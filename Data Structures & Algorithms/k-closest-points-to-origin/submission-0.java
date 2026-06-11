class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        for(int[] point: points){
            int x = point[0];
            int y = point[1];
            int dst = x*x+y*y;

            minHeap.offer(new int[]{dst,x,y});
        }

        int[][] res = new int[k][2];
        for(int i=0; i<k; i++){
            int[] curr = minHeap.poll();
            res[i][0] = curr[1];
            res[i][1] = curr[2];
        }
        return res;
    }
}
