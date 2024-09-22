class Solution {
    public int findKthNumber(int n, int k) {
        int currentPrefix = 1;
        k--;
        while(k>0){
            long firstNumber = currentPrefix;
            long nextNumber = currentPrefix + 1;
            int count = 0;
            while(firstNumber <= n){
                count += Math.min(n+1,nextNumber) - firstNumber;
                firstNumber *= 10;
                nextNumber *= 10;
            }

            if(k >= count){
                currentPrefix++;
                k -= count;
            }
            else{
                currentPrefix *= 10;
                k--;
            }
        }
        return currentPrefix;
    }
}