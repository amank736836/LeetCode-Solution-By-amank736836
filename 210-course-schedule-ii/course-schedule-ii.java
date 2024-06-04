class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        int indegree[] = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) if(indegree[i] == 0) q.add(i);
        
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
            int temp[] = new int[ans.size()];
            for(int i=0;i<ans.size();i++){
                temp[i] = ans.get(i);
            }
            return temp;
        }else{
            return new int[]{};
        }
    }
}