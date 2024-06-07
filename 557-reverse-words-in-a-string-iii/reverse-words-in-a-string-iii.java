class Solution {
    public String reverseWords(String S) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int y;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == ' '){
                y = ans.length();
                if(y>0 && ans.charAt(ans.length()-1) != ' ' && temp.length() > 0){
                    ans.append(" ");
                }
                ans.append(temp.reverse());
                //System.out.println(ans.length() + " / " + temp.length());
                temp = new StringBuilder();
            }else{
                temp.append(S.charAt(i));
            }
        }
        
        y = ans.length();
        if(y>0 && ans.charAt(ans.length()-1) != ' ' && temp.length() > 0){
            ans.append(" ");
        }
        ans.append(temp.reverse());
        //System.out.println(ans.length() + " / " + temp.length());


        return ans.toString();
    }
}