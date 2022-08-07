class Solution {
    
    int MOD=1000000007;
 
    public int countVowelPermutation(int n) {
        long dp[][]=new long[n+1][5];
        for(int i = 0; i < 5; i++)
        dp[1][i] = 1L;
    
        for(int i = 1; i < n; i++)
        {
            dp[i+1][0] = (dp[i][1] + dp[i][2] + dp[i][4]) %MOD;

            dp[i+1][1] = (dp[i][0] + dp[i][2]) % MOD;

            dp[i+1][2] = (dp[i][1] + dp[i][3]) % MOD;

            dp[i+1][3] = dp[i][2];

            dp[i+1][4] = (dp[i][2] + dp[i][3]) % MOD;
        }

        long res = 0;
        for(int i = 0; i < 5; i++)
            res = (res + dp[n][i]) % MOD;

        return (int)res;
        }
    
}