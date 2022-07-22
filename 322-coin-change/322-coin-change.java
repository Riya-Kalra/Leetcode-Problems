class Solution {
    
    public int coinChange(int[] coins, int a) {
        int prev[]= new int[a+1];
        int dp[]= new int[a+1];
        for(int j=0;j<=a;j++){
            if(j%coins[0]==0)
                prev[j]=j/coins[0];
            else
                prev[j]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=a;j++){
                int notTake=prev[j];
                int Take=Integer.MAX_VALUE-1;
                if(coins[i]<=j)
                    Take=1+dp[j-coins[i]];
                
                dp[j]=Math.min(Take,notTake);  
            }
            prev=dp;
        }
        int ans=prev[a];
        if(ans==Integer.MAX_VALUE-1) return -1;
        return ans;
    }
}