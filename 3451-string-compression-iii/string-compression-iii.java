class Solution {
    public String compressedString(String word) {
        if(word == null || word.length() == 0){
            return "";
        }

        String comp = "";
        int count = 1;
        char currentChar = word.charAt(0);
        for(int i=1;i<word.length();i++){
            if(word.charAt(i) == currentChar && count < 9){
                count++;
            }else{
                comp += ("" +count) + currentChar;
                count = 1;
                currentChar = word.charAt(i);
            }
        }

        comp += (count + "") + currentChar;
        return comp;
    }
}