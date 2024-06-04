class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int maxCount = 0;
        int maxValue = -1;

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int x = hm.get(nums[i]);
                hm.put(nums[i],++x);
                if(maxCount<x){
                    maxCount = x;
                    maxValue = nums[i];
                }
            }else{
                hm.put(nums[i],1);
                if(maxCount == 0 ){
                    maxCount = 1;
                    maxValue = nums[i];
                }
            }
        }

        return maxValue;
    }
}