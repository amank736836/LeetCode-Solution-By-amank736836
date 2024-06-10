class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words , (a,b) -> a.length() - b.length() );
        System.out.println(Arrays.toString(words));
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(compare(words[i],words[j]) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }

    public boolean compare(String s,String t){
        int n = s.length();
        int m = t.length();
        if( n != m + 1 ){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i<n && j<m){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        if(i==j || i == j+1){
            return true;
        }
        return false;
    }

}