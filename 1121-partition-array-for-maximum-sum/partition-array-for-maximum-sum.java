class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int maxi = Integer.MIN_VALUE;
            int sum = 0;
            int value = arr[i];
            int len = 0;
            for(int j=i;j<Math.min(n,i+k);j++){
                value = Math.max(value,arr[i+len]);
                len++;
                sum = (value * len) + dp[i+len];
                maxi = Math.max(maxi,sum);
            }
            dp[i] = maxi;

        }
        return dp[0];
    }
}