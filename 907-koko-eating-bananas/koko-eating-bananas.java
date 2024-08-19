class Solution {
    public int check(int mid,int piles[]){
        int ans = 0;
        for(int i=0;i<piles.length;i++){
            ans += Math.ceil((double)piles[i] / (double) mid);
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int n = piles.length;
        for(int i=1;i<n;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int start = 1;
        int end = max;
        while(start<= end){
            int mid = start + (end - start) / 2;
            if(check(mid,piles) <= h){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}