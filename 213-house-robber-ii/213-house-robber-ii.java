class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1)
            return nums[0];
        if (n==2)
            return Math.max(nums[0],nums[1]);
       int first= rob1(nums,0,n-1);
        int second= rob1 (nums,1,n);
        return (Math.max(first,second));
        
    }
    public int rob1(int nums[],int s,int e){
        int t0=nums[s];
        int t1=Math.max(nums[s],nums[s+1]);
       int  c=s+2, t2=t1;
        while(c<e){
            t2=Math.max(t0+nums[c],t1);
            t0=t1;
            t1=t2;
            c++;
        }
        return t2;
    }
}