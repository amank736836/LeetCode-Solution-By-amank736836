class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        long x = 0;
        for(int i=0;i<n;i++){
            x = x ^ nums[i];
        }
        int rightmost = (int)((x & (x-1)) ^ x);
        int b1 = 0;
        int b2 = 0;
        for(int i=0;i<n;i++){
            if((rightmost & nums[i]) == 0){
                b1 = b1 ^ nums[i];
            }else{
                b2 = b2 ^ nums[i];
            }
        }

        return new int[]{b1,b2};
    }
}