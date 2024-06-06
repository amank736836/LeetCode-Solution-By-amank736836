class Solution {
    public int coinChange(int[] coins, int amount) {
        int curr[] = new int[amount+1];

        for(int index=0;index<coins.length;index++){
            for(int target=1;target<=amount;target++){
                if(index == 0){
                    if(target%coins[0] == 0){
                        curr[target] = target/coins[0];
                    }else{
                        curr[target] = (int)1e9;
                    }
                }
                else{
                    int nottake = curr[target];
                    int take = (int)1e9;
                    if(coins[index] <= target){
                        take = 1 + curr[target-coins[index]];
                    }
                    curr[target] = Math.min(take,nottake);
                }
            }
        }

        int ans = curr[amount];
        if(ans == 1e9){
            return -1;
        }   
        return ans;
    }
}