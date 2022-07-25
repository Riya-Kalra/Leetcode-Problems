class Solution {
    public int search(int[] nums, int target) {
        int s=0,e=nums.length-1;
        int N=nums.length;
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int next=(mid+1)%N;
            int prev=(mid-1+N)%N;
            //System.out.println(prev+" "+mid+" "+next);
            if(mid==e || (nums[mid]<nums[next] && nums[mid]<nums[prev])){
                ans=mid;break;
                
            }
            else if(nums[mid]<=nums[e]){
                e=mid-1;
                
            }
            else if(nums[mid]>=nums[s])
                s=mid+1;
        }
       // System.out.println(ans);
        int a= BS(nums,0,ans-1,target);
        int b=BS(nums,ans,nums.length-1,target);
        return Math.max(a,b);
    }
    public int BS(int nums[],int s, int e,int n){
        
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==n){
                ans=mid;
               // s=mid+1;
                break;
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