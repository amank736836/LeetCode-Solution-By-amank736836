class Solution {

    public void DFS(int i,int j,char[][] grid,int [][] visited){

        visited[i][j] = 1;

        int rowDel[] = {-1,0,1,0};
        int colDel[] = {0,1,0,-1};
        int newi;
        int newj;
        for(int x=0;x<4;x++){
            newi = i + rowDel[x];
            newj = j + colDel[x];
            if(newi >= 0 && newj >= 0 && newi < grid.length && newj < grid[0].length &&  
                grid[newi][newj] == '1' && visited[newi][newj] == 0){
                DFS(newi,newj,grid,visited);
            }
        }

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int visited[][] = new int[m][n];

        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    DFS(i,j,grid,visited);
                }
            }
        }

        return cnt;
    }
}