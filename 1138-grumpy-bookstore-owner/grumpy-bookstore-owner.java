class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int curWin = 0;
        int maxWin = 0;
        int j = 0;

        for(int i=0;i<n;i++){
            curWin += customers[i]*grumpy[i];
            maxWin = Math.max(curWin , maxWin);
            if(i >= minutes - 1){
                curWin -= customers[j] * grumpy[j++];
            }
        }

        int res = maxWin;
        for(j=0;j<grumpy.length;j++){
            res += customers[j] * (1 - grumpy[j]);
        }
        return res;
    }
}