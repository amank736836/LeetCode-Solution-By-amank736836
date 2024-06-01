class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();   
        int m = s.length();
        
        boolean prev[] = new boolean[m+1];

        prev[0] = true;
        
        for(int j=1;j<=m;j++){
            prev[j] = false;
        } 
        
        for(int i=1;i<=n;i++){
            boolean curr[] = new boolean[m+1];
            boolean flag = true;
            for(int x = 1;x<=i;x++){
                if(p.charAt(x-1) != '*'){
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;
            for(int j=1;j<=m;j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    curr[j] = prev[j-1];
                }
                else if(p.charAt(i-1) == '*'){
                    curr[j] = prev[j] || curr[j-1];
                }else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }

        return prev[m];


    }
}