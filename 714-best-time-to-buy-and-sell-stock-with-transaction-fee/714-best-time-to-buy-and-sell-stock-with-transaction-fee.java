class Solution {
    public int maxProfit(int[] price, int fee) {
        int p=price.length;
        int dp[][]=new int[p+1][2];
        for(int i=p-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1)
                    dp[i][1]=Math.max(-price[i]+dp[i+1][0],dp[i+1][1]);
                else
                    dp[i][0]=Math.max(price[i]-fee+dp[i+1][1],dp[i+1][0]);
            }
        }
        return dp[0][1];
        
    }
}
//bsp -1 -1 -1 -1 1 1
//ssp 0 0 0 5 5 8