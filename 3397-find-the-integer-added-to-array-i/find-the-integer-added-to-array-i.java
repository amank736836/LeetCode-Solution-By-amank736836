class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int min1 = nums1[0];
        int min2 = nums2[0];
        for(int i=0;i<n1;i++){
            if(nums1[i] < min1){
                min1 = nums1[i];
            }
            if(nums2[i] < min2){
                min2 = nums2[i];
            }
        }
        int val = min2 - min1;
       
        return val;
        
        
    }
}