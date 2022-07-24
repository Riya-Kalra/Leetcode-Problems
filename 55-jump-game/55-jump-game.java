class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        
        int i=0,max=nums[0];
        while(i<=Math.min(max,n-1)){
            max=Math.max(nums[i]+i,max);
            i++;
        }
        
        if(max>=n-1)
            return true;
        return false;
    }
}