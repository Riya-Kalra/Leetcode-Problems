class Solution {
    public int getMaximumGold(int[][] grid) {
        int n= grid.length,m= grid[0].length;
        int dp[][]= new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0)
                    max=Math.max(max,dfs(i,j,grid,dp));
            }
        }
        return max;
    }
    int xx[]={-1,0,1,0};
    int yy[]={0,1,0,-1};
    public int dfs(int x,int y,int grid[][], int dp[][]){
       
        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length  && grid[x][y]!=0){
            int val=grid[x][y];
            grid[x][y]=0;
            
            //if(dp[x][y]!=-1)
                //return dp[x][y];
            
            int cnt=0;
            
            for(int i=0;i<4;i++)
               cnt=Math.max(cnt,val+dfs(x+xx[i],y+yy[i],grid,dp));
            
            grid[x][y]=val;
            //dp[x][y]=cnt;
            return cnt;
            
        }
        else
            return 0;
    }
}