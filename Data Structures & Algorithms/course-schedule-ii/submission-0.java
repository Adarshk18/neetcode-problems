class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preMap = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            preMap.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre: prerequisites){
            preMap.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            order[index++] = curr;

            for(int next: preMap.get(curr)){
                indegree[next]--;

                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        return order;
    }
}
