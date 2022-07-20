class Solution {
    public void solve(char[][] board) {
        int n=board.length, m=board[0].length;
        int vis[][]=new int[n][m];
        int dir[][]={{1,0},{0,1},{-1,0},{0,-1} };
        
        for (int i=0;i<n;i++){    
            if(board[i][0]=='O')
                dfs(board,i,0,vis);
            if(board[i][m-1]=='O')
                dfs(board,i,m-1,vis);
            vis[i][0]=1;
            vis[i][m-1]=1;    
        }
        
        for (int j=0;j<m;j++){    
            if(board[0][j]=='O')
                dfs(board,0,j,vis);
            if(board[n-1][j]=='O')
                dfs(board,n-1,j,vis);
            vis[0][j]=1;
            vis[n-1][j]=1;          
        }
        
         for (int i=1;i<n-1;i++){
            for (int j=1;j<m-1;j++){
                if(vis[i][j]==0 && board[i][j]=='O')
                    board[i][j]='X';
            }
         }
    }
    void dfs(char b[][],int i,int j,int vis[][]){
        if(i>=0 && j>=0 && i<b.length && j<b[0].length && vis[i][j]==0 && b[i][j]=='O' ){
            vis[i][j]=1;
            dfs (b,i-1,j,vis);
            dfs (b,i+1,j,vis);
            dfs (b,i,j+1,vis);
            dfs (b,i,j-1,vis);
        }
            
    }
}