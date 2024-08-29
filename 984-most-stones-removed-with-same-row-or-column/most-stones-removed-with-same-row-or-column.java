class Solution {
    public int numOfIslands = 0;
    public void unionSets(int a,int b,int parent[]){
        int parA = findParent(a,parent);
        int parB = findParent(b,parent);
        if(parA != parB){
            parent[parB] = parA;
            numOfIslands--;
        }
    }

    public int findParent(int node,int parent[]){
        if(parent[node] == 0){
            parent[node] = node;
            numOfIslands++;
        }
        if(parent[node] == node){
            return node;
        }
        int par = findParent(parent[node],parent);
        return par;
    }

    public int removeStones(int[][] stones) {
        int parent[] = new int[20003];
        for(int stone[] : stones){
            unionSets(stone[0] + 1 , stone[1] + 10002,parent);
        }
        return stones.length - numOfIslands;
    }
}