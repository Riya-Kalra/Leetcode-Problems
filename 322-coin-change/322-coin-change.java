class Solution {
    public int coinChange(int[] coins, int amount) {
        int c=coins.length;
        int dp[][]=new int [c+1][amount+1];
        for(int i=0;i<=c;i++){
            for(int j=0;j<=amount;j++){
                if (j == 0)
                    dp[i][j] =  0;
                else if (i==0)
                    dp[i][j] =Integer.MAX_VALUE-1;
                else if (coins[i-1]<=j)
                    dp[i][j]= Math.min(0 + dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                else
                    dp[i][j]=0 + dp[i - 1][j];
            }
        }
        return dp [c][amount]>=Integer.MAX_VALUE-1?-1:dp [c][amount];
    }
}