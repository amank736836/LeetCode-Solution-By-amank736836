class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int prev[] = new int[obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            int curr[] = new int[obstacleGrid[0].length];
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(i==0 && j==0 && obstacleGrid[i][j] != 1){
                    curr[j] = 1;
                }
                else if(obstacleGrid[i][j] != 1){
                    int up = 0;
                    int left = 0;
                    if(i>0) up = prev[j];
                    if(j>0) left = curr[j-1];
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[obstacleGrid[0].length-1];
    }
}