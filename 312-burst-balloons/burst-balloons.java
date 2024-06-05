class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        int dp[][] = new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n;j++){
                int maximumCoin = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int coin = (arr[i-1] * arr[k] * arr[j+1]) + dp[i][k-1] + dp[k+1][j];
                    maximumCoin = Math.max(maximumCoin , coin);
                }

                dp[i][j] = maximumCoin;
            }
        }
        return dp[1][n];
    }

}