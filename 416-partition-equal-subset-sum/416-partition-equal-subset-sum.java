class Solution {
    int t[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        if(sum%2==1) return false;
        
        int target=sum/2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int  j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) { //empty ss{} sum will be 0
                    dp[i][j] = true;
                } else if(i == 0) { //empty ss{} sum cannot be greater than 0
                    dp[i][j] = false;
                } else if(j == 0 || dp[i - 1][j]) { 
                    dp[i][j] = true;
                } else if(j >= nums[i - 1]) { 
                    dp[i][j] = dp[i - 1][j - nums[i - 1]]; 
                }
            }
        }
        return dp[nums.length-1][sum/2];
        
    }
    
}