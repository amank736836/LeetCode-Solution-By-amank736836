class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int posIndex = 0;
        int negIndex = 1;

        int n = nums.length;
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                a[posIndex] = nums[i];
                posIndex += 2;
            }else{
                a[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return a;
    }
}