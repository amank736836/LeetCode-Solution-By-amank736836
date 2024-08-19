class Solution {
    public int minSteps(int n) {
        int steps = 0;
        if(n == 1){
            return steps;
        }
        int factor = 2;
        while(n > 1){
            while(n % factor == 0){
                steps += factor;
                n /= factor;
            }
            factor++;
        }
        return steps;

    }
}