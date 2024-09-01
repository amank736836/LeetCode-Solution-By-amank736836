class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m * n != original.length){
            return new int[0][0];
        }

        int arr2D[][] = new int[m][n];
        for(int i=0;i<m*n;i++){
            arr2D[i / n][i % n] = original[i];
        }
        return arr2D;
    }
}