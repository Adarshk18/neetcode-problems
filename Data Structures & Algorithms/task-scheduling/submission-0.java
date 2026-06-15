class Solution {
    public int leastInterval(char[] tasks, int n) {
        //cnt the freq of each tasks
        Map<Character, Integer> cnt = new HashMap<>();
        for(char task: tasks){
            cnt.put(task, cnt.getOrDefault(task,0)+1);
        }

        //mxhaeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(cnt.values());

        int time =0;
        Queue<int[]> q = new LinkedList<>();
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll()-1;
                if(count>0){
                    q.offer(new int[]{count,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
