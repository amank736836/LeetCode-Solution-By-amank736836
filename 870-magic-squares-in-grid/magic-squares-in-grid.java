class Solution {
    private boolean isMagicSquare(int i, int j, int grid[][]) {
        boolean seen[] = new boolean[10];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int num = grid[i + x][j + y];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];

        for (int k = 1; k < 3; k++) {
            if (sum != grid[i + k][j] + grid[i + k][j + 1] + grid[i + k][j + 2]) {
                return false;
            }
            if (sum != grid[i][j + k] + grid[i + 1][j + k] + grid[i + 2][j + k]) {
                return false;
            }
        }

        if(sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]){
            return false;
        }
        if(sum != grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j]){
            return false;
        }
        return true;

    }

    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        int row = grid.length;
        int col = grid[0].length;

        if (row < 3 || col < 3) {
            return 0;
        }

        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (isMagicSquare(i, j, grid)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
