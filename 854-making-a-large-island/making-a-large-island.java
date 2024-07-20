class DisjointSet{
    public int parent[];
    public int rank[];
    public int size[];

    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
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
            parent[ultimateParentU] = ultimateParentV;
            rank[ultimateParentV] += 1;
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

    boolean isValid(int row,int column,int size){
        return row >= 0 && column >= 0 && row < size && column < size;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int delete[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        DisjointSet djs = new DisjointSet(n*n);
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 1){
                    int  node = row * n + col;
                    for(int del[] : delete){
                        int newRow = row + del[0];
                        int newCol = col + del[1];
                        if(isValid(newRow,newCol,n) && grid[newRow][newCol] == 1){
                            int adjNode = newRow * n + newCol;
                            djs.unionBySize(node,adjNode);
                        }
                    }
                }
            }
        }

        int maxSize = 0;
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int del[] : delete){
                        int newRow = row + del[0];
                        int newCol = col + del[1];
                        if(isValid(newRow,newCol,n) && grid[newRow][newCol] == 1){
                            set.add(djs.findUltimateParent(newRow * n + newCol));
                        }
                    }
                    int totalSize = 1;
                    for(Integer component : set){
                        totalSize += djs.size[component];
                    }
                    maxSize = Math.max(maxSize,totalSize);
                    System.out.println(set);
                }
            }
        }
        return maxSize == 0 ? n*n : maxSize;
    }
}