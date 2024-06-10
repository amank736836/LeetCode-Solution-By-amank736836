class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i=0;i<m;i++){
            if(grid[i][0] == 1){
                q.add(new int[]{i,0});
                grid[i][0] = -1;
            }
            if(grid[i][n-1] == 1){
                q.add(new int[]{i,n-1});
                grid[i][n-1] = -1;
            }
        }

        for(int i=0;i<n;i++){
            if(grid[0][i] == 1){
                q.add(new int[]{0,i});
                grid[0][i] = -1;
            }
            if(grid[m-1][i] == 1){
                q.add(new int[]{m-1,i});
                grid[m-1][i] = -1;
            }
        }

        int rowDel[] = {-1,0,1,0};
        int colDel[] = {0,1,0,-1};
        
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.remove();
            for(int x=0;x<4;x++){
                int newi = i + rowDel[x];
                int newj = j + colDel[x];
                if(newi >= 0 && newj >= 0 && newi < m && newj < n && grid[newi][newj] == 1 ){
                    grid[newi][newj] = -1;
                    q.add(new int[]{newi,newj});
                }
            }
        }

        int cnt = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
                else if(grid[i][j] == -1){
                    grid[i][j] = 1;
                }
            }
        }

        return cnt;
    }
}