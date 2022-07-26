class Solution {
    public boolean exist(char[][] board, String word) {
        int vis[][] = new int[board.length][board[0].length];
       for (int i=0; i<board.length; i++) {
    	for (int j=0; j<board[i].length; j++) {
            
    	if ((word.charAt(0) == board[i][j]) && exist(board,word, i, j,0,vis))
            return true;
    	}
    }
    return false; 
    } 
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    boolean exist (char[][] b, String s,int i,int j,int x,int vis[][]){
        if(x==s.length()) return true;
        if(i<0 || i>=b.length || j<0 || j>=b[0].length || vis[i][j]==1) return false;
        boolean ans=false;
        if(s.charAt(x)==b[i][j]){
            vis[i][j]=1;
            for(int i1=0;i1<4;i1++){
                int xx=i+dx[i1];
                int yy=j+dy[i1];
                ans|= exist(b,s,xx,yy,x+1,vis);
            }
             vis[i][j]=0; 
        }
        return ans;
    }
}