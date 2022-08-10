class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int copy[]=nums.clone();
        int mid=(n-1)/2,l=0,index=1;
        for(int i = n - 1; i > mid; i--){
            nums[index] = copy[i];
            index += 2;
        }
        index = 0;
        for(int i = mid; i >= 0; i--){
            nums[index] = copy[i];
            index += 2;
        }
    }
}
//nums=123456
//ans=362514