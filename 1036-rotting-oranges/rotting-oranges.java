class Solution {
    public int orangesRotting(int[][] grid) {
       int[][] directions = {{-1,0},{0,1},{0,-1},{1,0}};

       int m = grid.length;
       int n = grid[0].length;

       Queue<int[]> q = new LinkedList<>();
       int fresh = 0;

       for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(grid[i][j] == 2){
                q.offer(new int[]{i,j});
            }
            else if(grid[i][j]==1){
                fresh++;
            }
        }
       }

       int mins = 0;
       while(!q.isEmpty() && fresh > 0){
        int size = q.size();
        for(int i = 0;i<size;i++){
            int[] curr = q.poll();

            for(int[] dir : directions){
                int newRow = dir[0]+curr[0];
                int newCol = dir[1]+curr[1];

                if(newRow<m && newRow>=0 && newCol<n && newCol>=0 && grid[newRow][newCol]==1){
                    grid[newRow][newCol] = 2;
                    q.offer(new int[]{newRow,newCol});
                    fresh--;

                }
            }
        }
        mins++;

       }
       return fresh == 0 ? mins : -1;
    }
}