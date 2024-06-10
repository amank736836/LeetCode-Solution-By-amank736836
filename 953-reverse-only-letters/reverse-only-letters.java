class Solution {
    public String reverseOnlyLetters(String s) {
        
        int n = s.length();

        char[] chars = s.toCharArray();
        
        int i = 0;
        int j = n-1;
        
        char x;
        char y;

        while(i<j){

            x = chars[i];
            y = chars[j];

            if( !((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z'))){
                i++;
            }
            else if( !((y >= 'a' && y <= 'z') || (y >= 'A' && y <= 'Z'))){
                j--;
            }
            else{
                chars[i] = y;
                chars[j] = x;
                i++;
                j--;
            }

        }

        String ans = new String(chars);
        return ans;
    }
}