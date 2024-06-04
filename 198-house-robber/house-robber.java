class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        int take;
        int nontake;
        for(int i=1;i<n;i++){
            take = nums[i] + prev2;
            nontake = prev;
            prev2 = prev;
            prev = Math.max(take,nontake);
        }
        return prev;
    }
}