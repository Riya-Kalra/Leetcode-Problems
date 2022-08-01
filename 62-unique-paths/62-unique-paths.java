class Solution {
    int count=0;
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp= new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
        
        return dfs(0,0,m,n);
    }
    public int dfs(int i,int j,int m,int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i<0 ||j<0 ||i>=m|| j>=n)
            return 0;
        if(dp[i][j]!=-1)return dp[i][j];
         dp[i][j]=dfs(i+1,j,m,n) +dfs(i,j+1,m,n);
        return dp[i][j];
    }
}