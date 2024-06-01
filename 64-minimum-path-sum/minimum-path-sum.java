class Solution {
    public int minPathSum(int[][] grid) {
        int prev[] = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            int curr[] = new int[grid[0].length];
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    curr[j] = grid[i][j];
                }
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = grid[i][j] + prev[j];
                    if(j>0) left = grid[i][j] + curr[j-1];
                    curr[j] = Math.min(up,left);
                }
            }
            prev = curr;
        }
        return prev[grid[0].length-1];
    }
}