class Solution {
    public int longestIdealString(String str, int k) {
        
        int res=0;
        int len=str.length();
        int dp[]=new int[len+1];
        char s[]=str.toCharArray();
        int pos[]= new int [26];
        for(int i=0;i<=len;i++)
            dp[i]=1;
        for(int i=0;i<26;i++) 
            pos[i]=-1;
        for(int i=0;i<len;i++){
            for(int j=0;j<26;j++) 
                if(pos[j]!=-1 && Math.abs(s[i]-'a'-j)<=k){
                dp[i]=Math.max(dp[i],dp[pos[j]]+1);
            }
            pos[s[i]-'a']=i;
        }
        for(int i=0;i<len;i++) res=Math.max(res,dp[i]);
        return res;
    }
}