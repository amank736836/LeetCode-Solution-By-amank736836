class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int current = 0;
        for(int i=0;i<nums.length;i++){
            current += nums[i];
            if(current == 0){
                count++;
            }
        }
        return count;
    }
}