class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int count[] = new int[n];
        Arrays.fill(count,1);

        int maxi = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){

                if(nums[i] > nums[j]){
                    if(1+dp[j] > dp[i]){
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }
                    else if(1 + dp[j] == dp[i]){
                        count[i] += count[j];
                    }
                }

            }
            maxi = Math.max(maxi,dp[i]);
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxi){
                cnt += count[i];
            }
        }   

        return cnt;

    }
}