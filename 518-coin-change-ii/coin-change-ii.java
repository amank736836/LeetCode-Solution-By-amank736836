class Solution {
    
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        prev[0] = 1;
        for(int index = 0;index<n;index++){
            for(int target=0;target<=amount;target++){
                if(index == 0){
                    if(target%coins[index] == 0){
                        prev[target] = 1;
                    }else{
                        prev[target] = 0;
                    }
                }
                else{
                    int nottake = prev[target];
                    int take = 0;
                    if(coins[index] <= target){
                        take = prev[target-coins[index]];
                    }
                    prev[target] = take+nottake;
                }
            }
        }
        return prev[amount];
    }

}