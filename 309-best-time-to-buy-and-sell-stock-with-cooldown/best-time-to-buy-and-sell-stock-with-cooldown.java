class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int after2 = 0;
        int after1[] = new int[2];
        int curr[] = new int[2];
        for(int index=n-1;index>=0;index--){
            curr[0] =  Math.max( -prices[index] + after1[1] , after1[0] );
            curr[1] =  Math.max( prices[index] + after2 , after1[1] );
            after2 = after1[0];
            after1[0] = curr[0];
            after1[1] = curr[1];

        }
        return after1[0];
    }
}