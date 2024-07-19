class Solution {
    boolean visited[];
    List<Integer> adj[];
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }

        visited = new boolean[n];
        adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int edge[] : connections){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int components = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                components++;
            }
        }
        return components - 1;
    }

    private void dfs(int node){
        visited[node] = true;

        for(int neighbour : adj[node]){
            if(!visited[neighbour]){
                dfs(neighbour);
            }
        }
    }
}