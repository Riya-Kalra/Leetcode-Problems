class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,leftmax=0,rightmax=0,ans=0;
        while(left<=right){
            leftmax=Math.max(leftmax,height[left]);
            rightmax=Math.max(rightmax,height[right]);
            if(leftmax<rightmax){
                ans+=leftmax-height[left];//as if after rightmax any element come bigger than it still leftmax will be consider and if right is smaller rightmax will remain same and min of leftmax and rightmax will remain leftmax
                left++;
            }
            else{
                ans+=rightmax-height[right];
                right--;
            }
        }
        return ans;
    }
}