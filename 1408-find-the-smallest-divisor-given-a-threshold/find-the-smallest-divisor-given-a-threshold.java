class Solution {

    public boolean check(int nums[],int divisor,int threshold){
        int limit = 0;
        for(int num : nums){
            limit += (num + divisor - 1) / divisor;
        }
        return limit <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if(threshold < n){
            return -1;
        }
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int num : nums){
            end = Math.max(end,num);
        }
        int divisor = end;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(nums,mid,threshold)){
                divisor = Math.min(divisor,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return divisor;
    }
}