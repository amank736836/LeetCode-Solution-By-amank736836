class Solution {
    public long largestPerimeter(int[] nums) {
       return f1(nums , nums.length); 
    }
        
    long f1(int[] nums , int end){
        int maxIndex = 0;
        long sum = 0 ;
        for(int i=0 ; i< end ;i++)
        {
            sum += nums[i];
                
            if( nums[i]> nums[maxIndex])
                maxIndex= i;
        }
        if((sum-nums[maxIndex])> nums[maxIndex])
            return sum ;
        else
        {   
            int temp = nums[maxIndex];
            nums[maxIndex]=nums[end-1];
            nums[end-1]=temp;
            if(end < 3)
                return -1;
            return f1(nums, end-1);
        }
    }
}