class Solution {
    int dp[][];
    public int coinChange(int[] coins, int a) {
      
        dp= new int[coins.length][a+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
           // System.out.println(Arrays.toString(dp[i]));
        }
        int ans=solve(coins.length-1,a,coins) ;
        if(ans==Integer.MAX_VALUE-1) return -1;
        return ans;
    }
    public int solve (int i,int a,int coins[]){
       // System.out.println(i+" "+a);
        if(i==0){
            if(a%coins[i]==0)
                return a/coins[i];
            else
                return Integer.MAX_VALUE-1;
        }
        if(dp[i][a]!=-1) return dp[i][a];
        int Take=Integer.MAX_VALUE-1;
        if(coins[i]<=a)
            Take=1+solve(i,a-coins[i],coins);
        int notTake=solve(i-1,a,coins);
        return  dp[i][a]=Math.min(Take,notTake);
    }
}