class NumMatrix {
    int sum[][];
    public NumMatrix(int[][] mat) {
        int n= mat.length,m= mat[0].length;
        sum= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0)
                    sum[i][j]=mat[i][j];
                else if (i==0)
                    sum[i][j]=sum[i][j-1]+mat[i][j];
                else if (j==0)
                    sum[i][j]=sum[i-1][j]+mat[i][j];
                else{
                    sum[i][j]=sum[i-1][j]+sum[i][j-1]+mat[i][j]-sum[i-1][j-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        ans=sum[row2][col2];
        if(row1>0)
            ans-=sum[row1-1][col2];
        if(col1>0)
            ans-=sum[row2][col1-1];
        if(row1>0 && col1>0)
            ans+=sum[row1-1][col1-1];
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */