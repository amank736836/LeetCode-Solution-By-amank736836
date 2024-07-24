class Solution {

    private int timer = 1;

    public void dfs(int child, int parent, List<List<Integer>> adj, boolean visited[], int timeInsertion[],
            int lowestTimeInsertion[], List<List<Integer>> bridges) {
        visited[child] = true;
        timeInsertion[child] = timer;
        lowestTimeInsertion[child] = timer;
        timer++;
        for (int subChild : adj.get(child)) {
            if (subChild == parent) {
                continue;
            }
            if (visited[subChild]) {
                lowestTimeInsertion[child] = Math.min(lowestTimeInsertion[child], lowestTimeInsertion[subChild]);
            } else {
                dfs(subChild, child, adj, visited, timeInsertion, lowestTimeInsertion, bridges);
                lowestTimeInsertion[child] = Math.min(lowestTimeInsertion[child], lowestTimeInsertion[subChild]);
                if (lowestTimeInsertion[subChild] > timeInsertion[child]) {
                    bridges.add(Arrays.asList(subChild, child));
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        boolean visited[] = new boolean[n];
        int timeInsertion[] = new int[n];
        int lowestTimeInsertion[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, visited, timeInsertion, lowestTimeInsertion, bridges);
        return bridges;
    }
}