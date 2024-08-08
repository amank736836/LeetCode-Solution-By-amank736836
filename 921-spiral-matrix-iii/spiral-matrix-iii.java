class Solution {
    private int[][] convertListToArray(List<int[]> result){
        int array[][] = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            array[i] = result.get(i);
        }
        return array;
    }
    
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int numSteps = 1;
        int totalCells = rows * cols;
        List<int[]> result = new ArrayList<>();
        int r = rStart;
        int c = cStart;
        int d = 0;

        while(result.size() < totalCells){
            for(int i=0;i<2;i++){
                for(int j=0;j<numSteps;j++){
                    if( r >= 0 && r < rows && c >= 0 && c < cols){
                        result.add(new int[]{r,c});
                    }
                    if(result.size() == totalCells){
                        return convertListToArray(result);
                    }
                    r += directions[d][0];
                    c += directions[d][1];
                }
                d = (d + 1) % 4;
            }
            numSteps++;
        }

        return convertListToArray(result);
    }

    
}