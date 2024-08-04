class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> subArray = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                subArray.add(sum);
            }
        }
        Collections.sort(subArray,(a,b) -> a - b);
        int rSum = 0;
        for(int l = left - 1;l < right;l++){
            rSum = (rSum + subArray.get(l)) % 1000000007;
        }
        return rSum;
    }
}