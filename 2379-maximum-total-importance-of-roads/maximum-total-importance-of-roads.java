class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        long [] degree = new long[n];
        for(int[] road : roads){
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);
        
        long res = 0;
        long cost = 1;
        for(long city : degree){
            res += city * cost;
            cost++;
        }

        return res;

    }
}