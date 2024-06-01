class Solution {
    public int[] twoSum(int[] nums, int K) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            Integer c = hm.get(K-nums[i]);
            if(c!=null){
                return new int[] {c, i};
            }
                hm.put(nums[i],i);
        }
        return null;
    }
}