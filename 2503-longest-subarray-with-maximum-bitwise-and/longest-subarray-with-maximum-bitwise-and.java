class Solution {
    public int longestSubarray(int[] nums) {
        int length = 0;
        int maxL = 0;
        int max = Integer.MIN_VALUE;
        for(int n  :nums){
            if(max < n){
                max = n;
                maxL = 1;
                length = 1;
            }
            else if(max == n){
                length++;
            }else{
                maxL = Math.max(length,maxL);
                length = 0;
            }
        }
        maxL = Math.max(length,maxL);
        return maxL;

    }
}