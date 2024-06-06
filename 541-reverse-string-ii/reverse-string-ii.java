class Solution {
    public String reverseStr(String s, int k) {

        int n = s.length();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int x = k;
        int i=0;
        while(i<n){
            if(x==0){
                ans.append(temp.reverse());
                temp = new StringBuilder();
                for(int j=0;j<k && j+i<n;j++){
                    ans.append(s.charAt(i+j));
                }
                i += k;
                x=k;
            }
            if(i<n){
                temp.append(s.charAt(i));
            }
            x--;
            i++;
        }
        ans.append(temp.reverse());
        return ans.toString();

    }
}