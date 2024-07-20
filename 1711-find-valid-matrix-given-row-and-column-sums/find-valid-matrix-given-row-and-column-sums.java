class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int rows = rowSum.length;
        int cols = colSum.length;
        
        int currRow = 0;
        int currCol = 0;

        int res[][] = new int[rows][cols];

        while(currRow < rows || currCol < cols){

            if(currRow >= rows){
                res[rows - 1][currCol] = colSum[currCol];
                currCol++;
                continue;
            }
            else if(currCol >= cols){
                res[currRow][cols - 1] = rowSum[currRow];
                currRow++;
                continue;
            }

            int valueToPut = Math.min(rowSum[currRow],colSum[currCol]);

            rowSum[currRow] -= valueToPut;
            colSum[currCol] -= valueToPut;
            res[currRow][currCol] = valueToPut;

            if(rowSum[currRow] == 0){
                currRow++;
            }

            if(colSum[currCol] == 0){
                currCol++;
            }

        }   

        return res;

    }
}