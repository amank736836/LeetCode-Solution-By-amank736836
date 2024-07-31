class Solution {
    public int divide(int dividend, int divisor) {
        int num = 0;
        int count = 0;
        if (divisor == 1) {
            return dividend;
        }
        int sign = 1;
        if ((dividend < 0) != (divisor < 0)) {
            sign = -1;
        }

        long dividend2 = Math.abs((long)dividend);
        long divisor2 = Math.abs((long)divisor);

        for (int i = 30; i >= 0; i--) {
            if(dividend2 >= (divisor2 << i)){
                count += (1 << i);
                dividend2 -= (divisor2 << i);
            }
        }

        return count * sign;

    }
}