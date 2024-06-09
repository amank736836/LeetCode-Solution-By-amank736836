class Pair{
    int first;
    int second;
    Pair(int f,int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1] , times[i][2]));
        }
        Queue<Pair> pq = new LinkedList<>();
        int[] dist = new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = (int) 1e9;
        }
        dist[k] = 0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            int node = pq.peek().first;
            int distance = pq.peek().second;
            pq.remove();
            for(Pair it : adj.get(node)){
                int adjacentNode = it.first;
                int edgeWeight = it.second;
                if(dist[node] + edgeWeight < dist[adjacentNode]){
                    dist[adjacentNode] = dist[node] + edgeWeight;
                    pq.add(new Pair(adjacentNode , distance + 1));
                }
            }
        }
        int maxDistance = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i] == 1e9){
                return -1;
            }else{
                maxDistance = Math.max(maxDistance , dist[i]);
            }
        }
        return maxDistance;

    }
}