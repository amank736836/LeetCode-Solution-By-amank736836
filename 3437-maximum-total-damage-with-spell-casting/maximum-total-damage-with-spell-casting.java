class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int p : power){
            frequency.put(p,frequency.getOrDefault(p,0)+1);
        }
        List<Integer> uniquePowers = new ArrayList<>(frequency.keySet());
        Collections.sort(uniquePowers);
        
        int n = uniquePowers.size();
        long[] dp = new long[n+1];
        for(int i=1;i<=n;i++){
            int powerValue = uniquePowers.get(i-1);
            long totalDamage = (long) powerValue * frequency.get(powerValue);
            
            dp[i] = dp[i-1];
            
            int skipIndex = i-2;
            while(skipIndex >= 0 && uniquePowers.get(skipIndex) >= powerValue - 2){
                skipIndex--;
            }
            dp[i] = Math.max(dp[i] , totalDamage + (skipIndex >= 0 ? dp[skipIndex + 1]: 0));
        }
        
        return dp[n];
    }

}