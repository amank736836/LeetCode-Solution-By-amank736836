class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        int rowDel[] = {-1,0,1,0};
        int colDel[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.remove();
            for(int x=0;x<4;x++){
                int newi = i + rowDel[x];
                int newj = j + colDel[x];

                if(newi >= 0 && newj >= 0 && newi < m && newj < n && mat[newi][newj] == -1){
                    mat[newi][newj] = mat[i][j] + 1;
                    q.add(new int[]{newi,newj});
                }
            }
        }

        return mat;

    }
}