class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int after[][] = new int[2][3];
        for(int index=n-1;index>=0;index--){
            for(int cap=1;cap>=0;cap--){
                after[0][cap] = Math.max(-prices[index] + after[1][cap] , after[0][cap] );
                after[1][cap] = Math.max(prices[index] + after[0][cap+1], after[1][cap] );
            }
        }
        return after[0][0];
    }
}