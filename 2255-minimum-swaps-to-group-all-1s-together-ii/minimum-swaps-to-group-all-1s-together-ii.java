class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        for(int num : nums){
            totalOnes += num;
        }

        if(totalOnes == 0 || totalOnes == n){
            return 0;
        }

        int windowOnes = 0;
        for(int i=0;i<totalOnes;i++){
            windowOnes += nums[i];
        }

        int maxOnes = windowOnes;

        for(int i=0;i<n;i++){
            windowOnes -= nums[i];
            windowOnes += nums[ (i + totalOnes) % n];
            maxOnes = Math.max(maxOnes , windowOnes);
        }

        return totalOnes - maxOnes;
        
    }
}