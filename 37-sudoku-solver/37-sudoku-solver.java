class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    public boolean solve(char[][] board) {
        int n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    for(char ch='1' ;ch<='9';ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j] = ch;
                                if (solve(board))
                                  return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
        
    }
    public boolean isValid(char board[][],int x,int y, char ch){
        for(int i=0;i<board.length;i++){
            if(board[i][y]==ch)//each row should have 1 
                return false;
            if(board[x][i]==ch)//each col should have 1 
                return false;
            int r=3 * (x / 3) + i / 3, c= 3 * (y / 3) + i % 3;
            if(r>=0 &&r< board.length && c>=0 && c<board.length && board[r][c]==ch)//each block should have 1 
                return false;
        }
        return true;
    }
}