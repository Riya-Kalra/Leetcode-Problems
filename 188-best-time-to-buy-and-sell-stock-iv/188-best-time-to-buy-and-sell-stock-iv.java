class Solution {
    int dp[][][];
    public int maxProfit(int k, int[] prices) {
        dp= new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1],-1);
        }
        return solve(0,1,k,prices);
        
    }
    public int solve(int i,int buy,int cap,int prices[]){
        if(cap==0 || i==prices.length)
            return 0;
        if(dp[i][buy][cap]!=-1)
            return dp[i][buy][cap];
        if(buy==1){
            return dp[i][buy][cap]=Math.max(-prices[i]+solve(i+1,0,cap,prices),solve(i+1,1,cap,prices));
        }
        else
            return dp[i][buy][cap]=Math.max(+prices[i]+solve(i+1,1,cap-1,prices),solve(i+1,0,cap,prices));
    }
}