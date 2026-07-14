class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i] =i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int node){
        if(parent[node]!=node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private boolean union(int u, int v){
        int p1 = find(u);
        int p2 = find(v);

        if(p1==p2){
            return false;
        }

        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
