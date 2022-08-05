class Solution {
    public int findCircleNum(int[][] a) {
        int n=a.length, c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    dfs(i,j,a);
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int i,int j,int [][]a){
        if(a[i][j]==1){
            a[i][j]=0;
            for(int k=0;k<a.length;k++){
                dfs(i,k,a);
                dfs(k,j,a);
            }
        }
    }
}