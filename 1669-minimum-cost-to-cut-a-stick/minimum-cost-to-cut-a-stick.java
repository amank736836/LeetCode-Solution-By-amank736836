class Solution {
    
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int arr[] = new int[c+2];
        arr[0] = 0;
        for(int i=0;i<c;i++){
            arr[i+1] = cuts[i];
        }
        arr[c+1] = n;
        Arrays.sort(arr);
        int dp[][] = new int[c+2][c+2];

        for(int i=c;i>=1;i--){
            for(int j=i;j<=c;j++){
                int minimumCost = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost = (arr[j+1] - arr[i-1]) + dp[i][k-1] + dp[k+1][j];
                    minimumCost = Math.min(minimumCost , cost);
                }
                dp[i][j] = minimumCost;
            }
        }
        return dp[1][c];
    }
}