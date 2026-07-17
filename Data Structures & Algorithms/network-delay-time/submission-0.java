class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int[] time: times){
            graph.computeIfAbsent(time[0], x->new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        
        minHeap.add(new int[]{0,k});
        Set<Integer> vis = new HashSet<>();
        int ans =0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int time = curr[0];
            int node = curr[1];

            if(vis.contains(node)){
                continue;
            }

            vis.add(node);
            ans = Math.max(ans, time);

            if(!graph.containsKey(node)) continue;

            for(int[] nei: graph.get(node)){
                int nextnode = nei[0];
                int weight = nei[1];

                if(!vis.contains(nextnode)){
                    minHeap.offer(new int[]{time+weight, nextnode});
                }
            }
        }
        return vis.size() == n? ans : -1;
    }
}
