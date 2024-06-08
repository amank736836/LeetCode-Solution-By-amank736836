class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int afterBuy = 0;
        int afterNotBuy = 0;
        int currBuy = 0;
        int currNotBuy = 0;

        for(int index=n-1;index>=0;index--){
            currBuy = Math.max( -prices[index]  + afterNotBuy , afterBuy );
            currNotBuy = Math.max( prices[index] - fee + afterBuy , afterNotBuy );
            afterBuy = currBuy;
            afterNotBuy = currNotBuy;

        }
        return afterBuy;
    }
}