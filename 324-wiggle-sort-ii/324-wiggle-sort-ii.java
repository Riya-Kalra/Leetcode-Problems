class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int copy[]=nums.clone();
        int mid=(n)/2,l=0,index=1;
        for(int i = nums.length - 1; i > (nums.length - 1) / 2; i--){
            nums[index] = copy[i];
            index += 2;
        }
        index = 0;
        for(int i = (nums.length - 1) / 2; i >= 0; i--){
            nums[index] = copy[i];
            index += 2;
        }
    }
}