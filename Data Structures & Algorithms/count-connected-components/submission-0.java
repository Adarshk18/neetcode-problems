class Solution {
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] =i;
            rank[i] = i;
        }

        int components = n;
        for(int[] edge: edges){
            components -= union(edge[0], edge[1]);
        }
        return components;
    }

    private int find(int node){
        int root = node;
        while(root != parent[root]){
            parent[root] = parent[parent[root]];
            root = parent[root];
        }
        return root;
    }

    private int union(int u, int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU==rootV){
            return 0;
        }

        if(rank[rootV]>rank[rootU]){
            parent[rootU] = rootV;
            rank[rootV] += rank[rootU];
        }else{
            parent[rootV] = rootU;
            rank[rootU] += rank[rootV];
        }
        return 1;
    }
}
