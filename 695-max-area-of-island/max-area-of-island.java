class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int visited[][] = new int [m][n];

        int maxArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int area = 0;
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    area = DFS(i,j,grid,visited);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public int DFS(int i,int j,int [][] grid , int [][] visited){

        visited[i][j] = 1;
        int area = 1;
        
        int m = grid.length;
        int n = grid[0].length;

        int rowDel[] = {-1,0,1,0};
        int colDel[] = {0,1,0,-1};
        int newi;
        int newj;
        for(int x = 0;x<4;x++){
            newi = i + rowDel[x];
            newj = j + colDel[x];
            if(newi>=0 && newj>=0 && newi<m && newj<n && grid[newi][newj] == 1 && visited[newi][newj] == 0){
                area += DFS(newi,newj,grid,visited);
            }
        }

        return area;

    }

}