class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            total += nums[i];
        }
        if(total-target<0 || (total-target)%2 != 0){
            return 0;
        }
        int sum = (total-target)/2;
        int prev[] = new int[sum+1];
        
        for(int index = 0;index<n;index++){
            for(int tar = sum;tar>=0;tar--){
                if(index == 0){
                    if(nums[0] == 0 && tar == 0) prev[tar] = 2;
                    else if(tar == 0 || nums[0] == tar) prev[tar] = 1;
                    else prev[tar] = 0;
                }else{
                    int nottake = prev[tar];
                    int take = 0;
                    if(nums[index] <= tar){
                        take = prev[tar-nums[index]];
                    }
                    prev[tar] = take+nottake;
                }
            }
        }

        return prev[sum];

    }
}