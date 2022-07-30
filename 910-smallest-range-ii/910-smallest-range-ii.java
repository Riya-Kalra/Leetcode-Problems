class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length,ans=nums[n-1]-(nums[0]);
        for(int i=1; i<n; i++){
            int max=Math.max(nums[n-1]-k,nums[i-1]+k);
            int min=Math.min(nums[0]+k,nums[i]-k);
            ans= Math.min(ans,max-min);
        }
        return ans;
    }
}
// 1  3  6 15 22 k=10
//11 13 16 25 32 a[i]+k
//-9 -7 -4  5 12 a[i]-k

