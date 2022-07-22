class Solution {
    public int maxProfit(int[] prices) {
        int p=prices.length;
        int dp[][][]=new int[p+1][2][3];
        for(int i=p-1;i>=0;i--){
           for(int j=0;j<=1;j++){
               for(int k=1;k<=2;k++){
                   if(j==1)//buy
                dp[i][j][k]=Math.max(-prices[i]+dp[i+1][0][k],dp[i+1][1][k]);
                   else
                dp[i][j][k]=Math.max(+prices[i]+dp[i+1][1][k-1],dp[i+1][0][k]);
               }
           }  
        }
        return dp[0][1][2];
    }
}