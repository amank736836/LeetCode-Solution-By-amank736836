class Pair{
    long first;
    long second;
    Pair(long f,long s){
        first = f;
        second = s;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for(int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1] , roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0] , roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> Long.compare(x.second,y.second));
        long[] dist = new long[n];
        int[] ways = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);
        while(pq.size() != 0){
            long node = pq.peek().first;
            long dis = pq.peek().second;
            pq.remove();
            for(Pair it : adj.get((int)node)){
                long adjNode = it.first;
                long edW = it.second;

                if(dis + edW < dist[(int)adjNode]){
                    dist[(int)adjNode] = dis + edW;
                    pq.add(new Pair(adjNode , dis + edW));
                    ways[(int)adjNode] = ways[(int)node];
                }
                else if(dis + edW == dist[(int)adjNode]){
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}