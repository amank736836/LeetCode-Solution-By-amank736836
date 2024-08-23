class Solution {

    private static int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        expression = expression.replace("-","+-");
        String fractions[] = expression.split("\\+");
        for(String fraction : fractions){
            if(!fraction.isEmpty()){
                String parts[] = fraction.split("/");
                int num = Integer.parseInt(parts[0]);
                int den = Integer.parseInt(parts[1]);

                numerator = numerator * den + num * denominator;
                denominator *= den;

                int gcd = gcd(Math.abs(numerator),Math.abs(denominator));
                numerator /= gcd;
                denominator /= gcd;
            }
        }
        return numerator + "/" + denominator;
    }
}