class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder(s);
        String t = str.reverse().toString();
        int prev[] = new int[n+1];
        for(int i=1;i<=n;i++){
            int curr[] = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr;
        }
        return n - prev[n];
    }
}