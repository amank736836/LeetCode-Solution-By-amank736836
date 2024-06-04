class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int temp[] = new int[n-1];
        int temp2[] = new int[n-1];
        for(int i=0;i<n;i++){
            if(i!=0) temp[i-1] = nums[i];
            if(i!=n-1) temp2[i] = nums[i];
        }

        return Math.max(dynamic(temp),dynamic(temp2));
    }

    public int dynamic(int []nums){
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