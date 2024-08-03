class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        if(n != arr.length){
            return false;
        }
        int counts[] = new int[1001];

        for(int i=0;i<n;i++){
            counts[target[i]]++;
            counts[arr[i]]--;
        }

        for(int count : counts){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}