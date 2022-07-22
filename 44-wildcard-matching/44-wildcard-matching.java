class Solution {
    public boolean isMatch(String str, String pat) {
        int p=pat.length(), s=str.length();
        boolean dp[][] = new boolean[p+1][s+1];
        for(int i=0;i<=s;i++){// pat="" str has char
            dp[0][i]=false;
        }
        for(int i=0;i<=p;i++){// pat has char str=""
            dp[i][0]=isAllStars(pat,i);
        }
        for(int i=1;i<=p;i++){
            for(int j=1;j<=s;j++){
                if(pat.charAt(i-1)==str.charAt(j-1)|| pat.charAt(i-1)=='?')
                    dp[i][j]=dp[i-1][j-1];
                else if(pat.charAt(i-1)=='*')
                    dp[i][j]=dp[i-1][j]|dp[i][j-1];
                else
                    dp[i][j]=false;
            }
        }
        return dp[p][s];
    }
    
    static boolean isAllStars(String S1, int i) {
    for (int j = 0; j < i; j++) {
      if (S1.charAt(j) != '*')
        return false;
    }
    return true;
  }

  static int f(String pat, String str, int p, int s, int[][] dp) {

    //Base Conditions
        if(s<0 && p<0) return 1;
        if(s>=0 && p<0) return 0;
        if(s<0 && p>=0)
      return isAllStars(pat, p) ? 1 : 0;

    if(dp[p][s]!=-1) return dp[p][s];
        if(str.charAt(s)==pat.charAt(p)|| pat.charAt(p)=='?'){
            return dp[p][s]=f(pat,str,p-1,s-1,dp);
        }
        else if(pat.charAt(p)=='*')
            return dp[p][s]=(f(pat,str,p,s-1,dp)==1 || f(pat,str,p-1,s,dp)==1)? 1:0 ;
        else 
            return 0;
    
  }
       
}