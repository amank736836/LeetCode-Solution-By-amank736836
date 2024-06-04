class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i = 0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int indegree[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int x;
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

        if(ans.size() == numCourses){
            return true;
        }
        else{
            return false;
        }
    }
}