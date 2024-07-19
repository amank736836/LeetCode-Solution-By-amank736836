class DisjointSet{
    int parent[];
    int size[];
    int rank[];

    DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    int findUltimateParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findUltimateParent(parent[node]);
    }

    void unionByRank(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV){
            return;
        }
        if(rank[ultimateParentU] < rank[ultimateParentV]){
            parent[ultimateParentU] = ultimateParentV;
        }
        else if(rank[ultimateParentV] < rank[ultimateParentU]){
            parent[ultimateParentV] = ultimateParentU;
        }
        else{
            parent[ultimateParentV] = ultimateParentU;
            rank[ultimateParentU]++;
        }
    }

    void unionBySize(int u,int v){
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV){
            return;
        }

        if(size[ultimateParentU] < size[ultimateParentV]){
            parent[ultimateParentU] = ultimateParentV;
            size[ultimateParentV] += size[ultimateParentU];
        }
        else{
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU] += size[ultimateParentV];
        }
    }

}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet djs = new DisjointSet(n);

        int extraEdges = 0;
        for(int edge[] : connections){
            int u = edge[0];
            int v = edge[1];
            if(djs.findUltimateParent(u) == djs.findUltimateParent(v)){
                extraEdges++;
            }else{
                djs.unionBySize(u,v);
            }
        }

        int componentsCount = 0;
        for(int i=0;i<n;i++){
            if(djs.findUltimateParent(i) == i){
                componentsCount++;
            }
        }

        if(extraEdges >= componentsCount - 1){
            return componentsCount-1;
        }
        return -1;
    }
}