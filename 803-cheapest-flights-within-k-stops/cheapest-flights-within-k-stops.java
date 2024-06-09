class Pair{
    int first;
    int second;
    Pair(int f,int s){
        first = f;
        second = s;
    }
}

class Tuple{
    int first, second, third;
    Tuple(int f,int s,int t){
        first = f;
        second = s;
        third = t;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k){
                continue;
            }

            for(Pair iter : adj.get(node)){
                int adjNode = iter.first;
                int edgeWeight = iter.second;

                if(cost + edgeWeight < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuple(stops + 1,adjNode,cost + edgeWeight));
                }
            }
        }
        if(dist[dst] == 1e9){
            return -1;
        }else{
            return dist[dst];
        }
    }
}