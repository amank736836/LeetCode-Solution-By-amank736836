class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int val : graph[i]){
                adj.get(val).add(i);
            }
        }
        int indegree[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int x;
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            x = q.remove();
            ans.add(x);
            for(int val : adj.get(x)){
                indegree[val]--;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }

        Collections.sort(ans);
        
        return ans;
    }
}