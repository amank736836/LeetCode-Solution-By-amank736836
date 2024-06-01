class Solution {
    public boolean isPalindrome(int x) {
        int copy = x; 
        int rev=0 ,d=0;
        
        if(x<0){
           return false;
        }
        int i = x;
        while(i>0){
            d=i%10;
            rev=rev*10+d;
            i=i/10;
        }
        return ( rev == x ); 
    }
}