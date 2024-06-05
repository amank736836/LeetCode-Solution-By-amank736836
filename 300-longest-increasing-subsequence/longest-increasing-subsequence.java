class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        for(int i=0;i<n;i++){
            hash[i] = i;
        }
        Arrays.fill(dp,1);
        int maxi = 1;
        int lastIndex = 0;
        for(int index = 0;index<n;index++){
            for(int prevIndex = 0;prevIndex<index;prevIndex++){
                if(nums[prevIndex] < nums[index] && 1+dp[prevIndex] > dp[index]){
                    dp[index] = 1+dp[prevIndex];
                    hash[index] = prevIndex;
                }
            }
            if(dp[index] > maxi){
                maxi = dp[index];
                lastIndex = index;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
		int len = maxi;
		for(int i=n-1;i>=0;i--){
			if(dp[i] == len){
				ans.add(nums[i]);
				len--;
			}
		}
        Collections.reverse(ans);
        System.out.println(ans);
        return ans.size();
    }
}