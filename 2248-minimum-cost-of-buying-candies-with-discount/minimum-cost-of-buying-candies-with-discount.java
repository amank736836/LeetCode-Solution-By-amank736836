class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int i = n-1;
        int k = 2;
        int ans = 0;
        while(i>=0){
            if(k==0){
                k=3;
            }
            else{
                ans += cost[i];
            }
            k--; 
            i--;
        }
        return ans;
    }
}