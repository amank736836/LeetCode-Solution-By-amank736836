class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
         int count = 0;
        
        int i = 0;
        int k = 0; 
        while(i+k+1<nums.length){
            if ((pattern[k] == 1 && nums[i + k + 1] > nums[i + k]) ||
                (pattern[k] == 0 && nums[i + k + 1] == nums[i + k]) ||
                (pattern[k] == -1 && nums[i + k + 1] < nums[i + k])) {

                if (k + 1 == pattern.length) {
                    i++;
                    count++;
                    k = 0;
                } else k++;
            } else{
                i++;
                k = 0;
            }
        }
        
        return count;
    }
}