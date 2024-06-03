class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                q.add(new int[]{i,0});
                board[i][0] = 'c';
            }
            if(board[i][n-1] == 'O'){
                q.add(new int[]{i,n-1});
                board[i][n-1] = 'c';
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O'){
                q.add(new int[]{0,i});
                board[0][i] = 'c';

            }
            if(board[m-1][i] == 'O'){
                q.add(new int[]{m-1,i});
                board[m-1][i] = 'c';
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

                if(newi >= 0 && newj >=0 && newi < m && newj < n && board[newi][newj] == 'O'){
                    board[newi][newj] = 'c';
                    q.add(new int[]{newi,newj});
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'c'){
                    board[i][j] = 'O';
                }
            }
        }

    }
}