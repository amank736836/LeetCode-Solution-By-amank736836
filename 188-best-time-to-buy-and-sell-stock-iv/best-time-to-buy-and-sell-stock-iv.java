class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int after[] = new int[(2*k)+1];
        for(int index=n-1;index>=0;index--){
            int curr[] = new int[(2*k)+1];
            for(int transaction = 0;transaction<2*k;transaction++){
                if(transaction%2 == 0){
                    curr[transaction] = Math.max(-prices[index] + after[transaction+1] , after[transaction] );
                }else{
                    curr[transaction] = Math.max(prices[index] +  after[transaction+1] , after[transaction] );
                }
            }
            after = curr;
        }
        return after[0];
    }
}