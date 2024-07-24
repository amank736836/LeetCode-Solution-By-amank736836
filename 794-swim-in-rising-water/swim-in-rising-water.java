class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        for(boolean row[] : visited){
            Arrays.fill(row,false);
        }
        pq.add(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty()){
            int poll[] = pq.poll();
            if(visited[poll[0]][poll[1]]){
                continue;
            }
            if(poll[0] == n -1 && poll[1] == n-1){
                return poll[2];
            }
            visited[poll[0]][poll[1]] = true;
            for(int direction[] : directions){
                int row = poll[0] + direction[0];
                int col = poll[1] + direction[1];
                if(row >= 0 && col >= 0 && row < n && col < n && !visited[row][col]){
                    pq.add(new int[]{row,col,Math.max(poll[2] , grid[row][col])});
                }
            }
        }
        return 0;
    }
}