class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int suffixSum[] = new int[n + 1];
        for(int i=n - 1;i>=0;i--){
            suffixSum[i] = suffixSum[i+1] + piles[i];
        }
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=2 * j && i + k <= n;k++){
                    dp[i][j] = Math.max(dp[i][j],suffixSum[i] - dp[i+k][Math.max(j,k)]);
                }
            }
        }
        return dp[0][1];
    }
}