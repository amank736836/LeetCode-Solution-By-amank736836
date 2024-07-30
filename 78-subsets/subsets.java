class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        int x = (1 << n);
        for(int num=0;num<x;num++){
            List<Integer> set = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num & (1 << i)) != 0){
                    set.add(nums[i]);
                }
            }
            subsets.add(set);
        }
        return subsets;
    }
}