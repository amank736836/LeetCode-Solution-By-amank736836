class Solution {
    public int checkRecord(int n) {
        if(n == 1){
            return 3;
        }
        int f[] = new int[n+1];
        int g[] = new int[n+1];
        f[0] = g[0] = 1;
        f[1] = 3;
        f[2] = 8;
        g[1] = 2;
        g[2] = 4;
        int MOD = (int) 1e9 + 7;
        for(int i=3;i<=n;i++){
            g[i] = ((g[i-1] + g[i-2]) % MOD + g[i-3]) % MOD;
            f[i] = (((f[i-1] + f[i-2]) % MOD + f[i-3]) % MOD + g[i]) % MOD;
        }

        return f[n];
    }
}