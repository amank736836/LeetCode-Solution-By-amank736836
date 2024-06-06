class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int i=0;i<n;i++) sum += nums[i];
        if(sum%2!=0)return false;
        int k = sum/2;

        boolean prev[] = new boolean[k+1];
        prev[0] = true; 

        if(nums[0] <= k) prev[nums[0]] = true;

        for(int index = 1;index<n;index++){
            boolean curr[] = new boolean[k+1];
            for(int target = 0;target <= k;target++){
                boolean nottake = prev[target];
                boolean take = false;
                if(nums[index] <= target) take = prev[target-nums[index]];
                curr[target] = (take || nottake);
            }
            prev = curr;
        }
        return prev[k];
    }
}