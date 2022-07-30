class Solution {
    public int minDistance(String w1, String w2) {
        int n=w1.length(), m=w2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0;j<=m;j++){
                if(i==0 && j==0)
                    dp[i][j]=0;
                else if(i==0)
                    dp[i][j]=j;
                else if (j==0)
                    dp[i][j]=i;
                else if(w1.charAt(i-1)==w2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
            }
        }
        //for(int i=0; i<=n; i++)
          // System.out.println(Arrays.toString(dp[i]));
        return dp[n][m];
    }
}