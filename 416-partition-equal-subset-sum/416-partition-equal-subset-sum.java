class Solution {
    int dp[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums){
            sum+=n;
        }
        if(sum%2==1)
            return false;
        dp= new int[nums.length][sum/2+1];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return solve(0,nums,sum/2);
    }
    public boolean solve(int i, int []nums, int target){
        if(target==0)
                return true;
        if(i==nums.length){
            if(target==0)
                return true;
            else
                return false;
        }
        if(dp[i][target]!=-1) 
            return dp[i][target]==0? false :true;
        boolean notTake=solve(i+1,nums,target);
        boolean take=false;
        if(nums[i]<=target)
            take=solve(i+1,nums,target-nums[i]);
        dp[i][target]= (take|notTake)==true?1:0;
        return take|notTake;
    }
}