class Solution {
    int r,c;
    boolean notCaptured[][];
    public void solve(char[][] board) {
        r = board.length; c = board[0].length;
        notCaptured = new boolean[r][c];
        for(int x = 0;x < r; x++){
            if(!notCaptured[x][0] && board[x][0] == 'O')
                dfs(board,x,0);
            if(!notCaptured[x][c-1] && board[x][c-1] == 'O')
                dfs(board,x,c-1);
        }
        for(int y = 0;y < c; y++){
            if(!notCaptured[0][y] && board[0][y] == 'O')
                dfs(board,0,y);
            if(!notCaptured[r-1][y] && board[r-1][y] == 'O')
                dfs(board,r-1,y);
        }
        for(int x = 0;x < r;x++){
            for(int y = 0;y < c;y++){
                    //System.out.println(notCaptured[x][y]);
                   if(!notCaptured[x][y])
                        board[x][y] = 'X';
            }
        }
    }
    public void dfs(char[][] board,int x, int y){
        notCaptured[x][y] = true;
        if(x-1 >= 0 && board[x-1][y] == 'O' && !notCaptured[x-1][y])
            dfs(board,x-1,y);
        if(x+1 <= r-1 && board[x+1][y] == 'O' && !notCaptured[x+1][y])
            dfs(board,x+1,y);
        if(y-1 >= 0 && board[x][y-1] == 'O' && !notCaptured[x][y-1])
            dfs(board,x,y-1);
        if(y+1 <= c-1 && board[x][y+1] == 'O' && !notCaptured[x][y+1])
            dfs(board,x,y+1);
    }
}