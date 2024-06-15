class Solution {
    public int maxOperations(int[] nums) {
        
        int c1 = maxOper(nums,0,nums[0]+nums[1]);
        return c1;
        
        /*
        
        int prevO = nums[0] + nums[1];
        int count = 1;
        int index = 2;
        while(index+1 < nums.length && nums[index]+nums[index+1]==prevO){
            count++;
            index += 2;
        }
        return count;
        
        */        
    }
    
    public int maxOper(int[]nums,int i,int p){
        if(i+1 < nums.length && nums[i]+nums[i+1] == p){
            return 1+maxOper(nums,i+2,p);
        }else{
            return 0;
        }
    }
}