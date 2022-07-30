class Solution {
    public int coinChange(int[] coins, int amount) {
        int c=coins.length;
        int prev[]=new int [amount+1];
        int dp[]=new int [amount+1];
        prev[0]=0;
        for(int j=1;j<=amount;j++)
            prev[j]=Integer.MAX_VALUE-1;
        for(int i=1;i<=c;i++){
            for(int j=0;j<=amount;j++){
                if (j == 0)
                    dp[j] =  0;
                else if (coins[i-1]<=j)
                    dp[j]= Math.min(0 + prev[j], 1 + dp[j - coins[i - 1]]);
                else
                    dp[j]=0 + prev[j];
            }
            prev=dp;
        }
        return prev[amount]>=Integer.MAX_VALUE-1?-1:prev[amount];
    }
}