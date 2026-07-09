class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> preMap = new ArrayList<>();

        for(int c=0; c<numCourses; c++){
            preMap.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visitSet = new HashSet<>();

        for(int i=0; i<numCourses; i++){
            if(!dfs(i, preMap, visitSet)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> preMap, Set<Integer> visitSet){
        if(visitSet.contains(course)){
            return false;
        }

        if(preMap.get(course).isEmpty()){
            return true;
        }

        visitSet.add(course);

        for(int pre: preMap.get(course)){
            if(!dfs(pre,preMap, visitSet)){
                return false;
            }
        }

        visitSet.remove(course);
        preMap.get(course).clear();

        return true;
    }
}
