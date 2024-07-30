class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int f[] = new int[n+1];
        int b = 0;
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1) == 'b'){
                b++;
                f[i] = f[i-1];
            }else{
                f[i] = Math.min(b,f[i-1] + 1);
            }
        }
        return f[n];
    }
}