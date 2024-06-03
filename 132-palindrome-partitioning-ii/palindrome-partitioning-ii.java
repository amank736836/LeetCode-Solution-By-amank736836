class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int maxi = Integer.MAX_VALUE;
            for(int k=i;k<n;k++){
                if(palindrome(i,k,s)){
                    maxi = Math.min(maxi , 1 + dp[k+1]);
                }
            }
            dp[i] = maxi;
        }
        return dp[0] - 1;
    }

    public boolean palindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}