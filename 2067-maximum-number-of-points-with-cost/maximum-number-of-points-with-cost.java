class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long dp[] = new long[n];

        for(int i=0;i<n;i++){
            dp[i] = points[0][i];
        }
        for(int i=1;i<m;i++){
            long leftMax[] = new long[n];
            long rightMax[] = new long[n];

            leftMax[0] = dp[0];
            for(int j=1;j<n;j++){
                leftMax[j] = Math.max(leftMax[j-1],dp[j] + j);
            }

            rightMax[n-1] = dp[n-1] - (n-1);
            for(int j=n-2;j>=0;j--){
                rightMax[j] = Math.max(rightMax[j+1],dp[j] - j);
            }

            for(int j=0;j<n;j++){
                dp[j] = Math.max(leftMax[j] - j , rightMax[j] + j) + points[i][j];
            }

        }


        long maxPoints = dp[0];
        for(int i=1;i<n;i++){
            maxPoints = Math.max(maxPoints,dp[i]);
        }
        return maxPoints;
    }
}