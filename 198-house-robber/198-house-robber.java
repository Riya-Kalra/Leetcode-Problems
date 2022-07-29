class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        //int dp[]=  new int[n];
        int prev0=nums[0];
        if(n==1) return prev0;
        int prev1=Math.max(nums[0],nums[1]);
        int curr=0;
        for(int i=2;i<n;i++){
            curr=Math.max(prev1,prev0+nums[i]);
            prev0=prev1;
            prev1=curr;
            
        }
        return prev1;
    }
}