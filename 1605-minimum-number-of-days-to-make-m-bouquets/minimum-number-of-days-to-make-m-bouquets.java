class Solution {
    public int possible(int[] arr , int day , int m , int k){
        int count  = 0;
        int bday = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= day){
                count++;
            }
            else{
                bday += (count/k);
                count = 0;
            }
        }
        bday += (count/k);
        return bday;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long var = (long) m*k;
        if(var > n){
            return -1;
        }
        int ans = -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int element : bloomDay){
            low = Math.min(low , element);
            high = Math.max(high , element);
        }
        while(low <= high){
            int mid = (low + high) / 2;
            int bday = possible(bloomDay , mid , m , k);
            if(bday >= m){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}