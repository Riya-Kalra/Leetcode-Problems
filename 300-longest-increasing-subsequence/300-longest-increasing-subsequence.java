class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp= new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return f(0,-1,nums);
    }
    int f(int i,int prev_i,int[] nums){
        if(i==nums.length)
            return 0;
        if(dp[i][prev_i+1]!=-1)
            return dp[i][prev_i+1];
        int len=0+f(i+1,prev_i,nums);//Not Take
        if(prev_i==-1 || nums[i]>nums[prev_i])
            len=Math.max(len,1+f(i+1,i,nums));
        
        return dp[i][prev_i+1]=len;  
    }
}