class Solution {
    public int maxProduct(int[] nums) {
      int n=nums.length,min=nums[0],max=nums[0],total=nums[0];
        for (int i=1;i<n;i++){
            if(nums[i]<0){
                int t=min;
                min=max;
                max=t;
            }
            max=Math.max(nums[i],max*nums[i]);
            min=Math.min(nums[i],min*nums[i]);
            total=Math.max(max,total);
        }
        return total;  
    }
}