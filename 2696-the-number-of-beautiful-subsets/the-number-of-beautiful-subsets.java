class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int count  = 0;
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums,k,0,temp,ans);
        return ans.size();
    }

    public void recursion(int[] nums,int k,int index,List<Integer> temp,List<List<Integer>> ans){
        if(index == nums.length){
            if(temp.size() > 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(!temp.contains(nums[index] - k)){
            temp.add(nums[index]);
            recursion(nums,k,index+1,temp,ans);
            temp.remove(temp.size() - 1);
        }
        recursion(nums,k,index+1,temp,ans);
    }
}