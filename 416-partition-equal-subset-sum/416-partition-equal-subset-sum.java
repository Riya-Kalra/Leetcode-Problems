class Solution {
    int t[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        if(sum%2==1) return false;
        t= new int [nums.length][(sum/2)+1];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(t[i],-1);
        return solve(nums.length-1,sum/2, nums);
        
    }
    public boolean solve (int i,int target,int[] nums){
        if(target ==0 ) return true;
        if(i==0){
            if(nums[i]==target) 
                return true;
            else
                return false;
        }
        if (t[i][target]!=-1)
            return t[i][target]==0? false: true;
        boolean notPick = solve(i-1,target, nums);
        boolean pick=false;
        if(nums[i]<=target) 
            pick= solve(i-1, target-nums[i], nums);
        t[i][target]=(pick|notPick)== false ? 0:1 ;
        return t[i][target]==0? false: true;
    }
}