class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
      Arrays.sort(nums);
        int diff=Integer.MAX_VALUE,psum=0;
        for(int i=0;i<n;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=nums[l]+nums[r]+nums[i];
                if(sum==target)
                    return target;
                else if (sum>target)
                    r--;
                else
                    l++;
                if(Math.abs(sum-target)<diff){
                    diff=Math.abs(sum-target);
                    psum=sum;
                }
            }
        }
         return psum;
    }
   
}