class Solution {
    public boolean isBipartite(int[][] graph) {      
        int visited[] = new int[graph.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        int x;
        int color;

        for(int i=0;i<graph.length;i++){
            if(visited[i] == 0){
                q.add(i);
                color = 1;
                visited[i] = color;
                while(!q.isEmpty()){
                    int size = q.size();
                    for(int j=0;j<size;j++){
                        x = q.pop();
                        for(int val : graph[x]){
                            if(visited[val] == 0){
                                visited[val] = -color;
                                q.add(val);
                            }else if(visited[val] != -color){
                                return false;
                            }
                        }
                    }
                    color = -color;
                }
            }
        }
        return true;
    }
}