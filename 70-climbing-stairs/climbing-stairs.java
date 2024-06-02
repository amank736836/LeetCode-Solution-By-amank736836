class Solution {
    public int climbStairs(int n) {
        int prev = 0;
        int prev2 = 1;
        int curr;
        for(int i=2;i<n+3;i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}