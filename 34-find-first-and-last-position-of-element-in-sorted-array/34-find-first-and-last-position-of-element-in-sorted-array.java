class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a[]=new int[2];
        a[0]=BSfloor(nums,target);
        a[1]= BSceil(nums,target);
        return a;
    }
    public int BSfloor(int nums[],int n){
       int s=0,e=nums.length-1;
        
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==n){
                ans=mid;
                e=mid-1;
                
            }
            else if(nums[mid]>n){
                e=mid-1;
                
            }
            else
                s=mid+1;
        }
        return ans;
    }
    public int BSceil(int nums[],int n){
       int s=0,e=nums.length-1;
        
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==n){
                ans=mid;
                s=mid+1;
            }
            else if(nums[mid]<n){
                
                s=mid+1;
            }
            else
                e=mid-1;
        }
        return ans;
    }
}