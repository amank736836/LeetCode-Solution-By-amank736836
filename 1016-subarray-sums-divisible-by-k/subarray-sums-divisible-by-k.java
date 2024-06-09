class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int dp[] = new int[nums.length + 1];
        int count = 0;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i,sum=0;j<nums.length;j++){
                sum += nums[j];
                if(sum % k == 0){
                    dp[i] = 1 + dp[j+1];
                    count += dp[i];
                    break;
                }
            }
        } 

        return count;
        
    }
}