class tuple{
    int first,second,third;
    tuple(int f,int s,int t){
        first = f;
        second = s;
        third = t;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(n==0 || grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        if(n==1){
            return grid[0][0] == 0 ? 1 : -1;
        }

        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1,0,0));
        dist[0][0] = 1;
        
        int dr[] = {-1,-1,-1,0,1,1,1,0};
        int dc[] = {1,0,-1,-1,-1,0,1,1};

        while(!q.isEmpty()){

            tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int r = it.second;
            int c = it.third;

            for(int i=0;i<8;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr >= 0 && newr<n && newc >= 0 && newc < n && grid[newr][newc] == 0 && 1 + dis < dist[newr][newc]){
                    dist[newr][newc] = dis + 1;
                    if(newr == n-1 && newc == n-1){
                        return dis + 1;
                    }
                    q.add(new tuple(1+dis,newr,newc));
                } 
            }
        }
        return -1;
    }
}