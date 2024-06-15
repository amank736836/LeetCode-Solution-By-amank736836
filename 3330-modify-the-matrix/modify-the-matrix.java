class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int ans[][] = matrix;
        for(int i=0;i<matrix[0].length;i++){
            int max = 0;    
            for(int k=0;k<matrix.length;k++){
                if(ans[k][i]>max){
                    max = ans[k][i];
                }
            }
            for(int k=0;k<matrix.length;k++){
                if(ans[k][i]== -1){
                    ans [k][i] = max;       
                }
            }
            
        }
        return ans;
    }
}