class Solution {
    public int addDigits(int num) {
        if(num % 10 == num)
            return num;
        else
            return addDigits(sum(num));
    }
    public int sum(int num)
    {
         if(num % 10 == num)
            return num;
            
        return num%10 + sum(num/10);
    }
}