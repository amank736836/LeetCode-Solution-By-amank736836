class Solution {

    public void dfs(int i,int[] visited,int[][] isConnected){
        visited[i] = 1;
        for(int j = 0;j<isConnected.length;j++){
            if(visited[j] == 0 && isConnected[i][j] == 1){
                dfs(j,visited,isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int visited[] = new int[isConnected.length];
        int ans = 0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i] == 0){
                ans++;
                dfs(i,visited,isConnected);
            }
        }
        return ans;
    }
}