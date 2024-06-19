class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = 1;
        }

        for(int t=0;t<k;t++){
            for(int i=1;i<n;i++){
                arr[i] += arr[i-1];
                arr[i] %= (int)1e9+7;
            }
        }

        return arr[n-1];
    }
}