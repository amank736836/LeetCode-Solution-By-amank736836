class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zero++;
            }else if(nums[i] == 1){
                one++;
            }else{
                two++;
            }
        }

        int idx = 0;

        for(int i=0;i<zero;i++){
            nums[idx] = 0;
            idx++;
        }
        for(int i=0;i<one;i++){
            nums[idx] = 1;
            idx++;
        }
        for(int i=0;i<two;i++){
            nums[idx] = 2;
            idx++;
        }


    }
}