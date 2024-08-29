class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    static void findCombinations(int index,int candidates[],int target,List<List<Integer>> ans,List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            ds.add(candidates[i]);
            findCombinations(i + 1,candidates,target-candidates[i],ans,ds);
            ds.remove(ds.size() - 1);
        }
    }
}