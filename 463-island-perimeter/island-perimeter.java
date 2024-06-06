class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int land = 0;
        int neigh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    land++;
                    if(i-1>=0 && grid[i-1][j] == 1){
                        neigh++;
                    }
                    if(j-1>=0 && grid[i][j-1] == 1){
                        neigh++;
                    }
                }
            }
        }

        return 4*land - neigh*2;

    }
}