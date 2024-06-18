class Solution {
    public boolean isValid(String word) {
        boolean vowels = false;
        boolean consonents = false;
        int charsCount = 0;
        boolean num = false;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean others = true;
        for(int i=0;i<word.length();i++){
            char x = word.charAt(i);
            if( x == 'a' || x =='e' || x=='i' || x=='o' || x=='u' || x=='A' || x=='E' || x=='I' || x=='O' || x=='U'){
                vowels = true;
                charsCount++;
            }
            if((x>='A' && x<='Z' && x!='A' && x!='E' && x!='I' && x!='O' && x!='U') || (x>='a' && x<='z' && x!='a' && x!='e' && x!='i' &&                   x!='o' && x!='u')){
                consonents = true;
                charsCount++;
            }
            if( x >= '1' && x <= '9'){
                num = true;
            }
            if(x>='A' && x<='Z'){
                upperCase = true;
            }
            if(x>='a' && x<='z'){
                lowerCase = true;
            }
            if( !(x>='A' && x<='Z') && !(x>='a' && x<='z') && !(x>='0' && x<='9')){
                others = false;
            }
        }
        System.out.println(others);
        return ((lowerCase || upperCase || num )&& vowels && consonents && word.length()>=3 && others);
    }
}