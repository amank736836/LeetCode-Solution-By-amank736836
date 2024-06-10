class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int prev[] = new int[n];
        for(int j=0;j<n;j++){
            prev[j] = Integer.MAX_VALUE;
        }
        for(int j=0;j<n;j++) prev[j] = matrix[0][j];
        for(int i=1;i<n;i++){
            int curr[] = new int[n];
            for(int j=0;j<n;j++){
                int up = matrix[i][j] + prev[j];
                int upleft = Integer.MAX_VALUE;
                if(j-1 >= 0) upleft = matrix[i][j] + prev[j-1];
                int upright = Integer.MAX_VALUE;
                if(j+1 < matrix.length) upright = matrix[i][j] + prev[j+1];

                curr[j] = Math.min(up , Math.min(upleft , upright));
            }
            prev = curr;
        }

        int maxi = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            maxi = Math.min(maxi,prev[j]);
        }
        return maxi;
    }
}