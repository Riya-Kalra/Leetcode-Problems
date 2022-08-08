class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
         int n=nums.length,lis=0;
        int inc_seq[]=new int[n];
        inc_seq[0]=nums[0];int k=0;
        for (int i=1;i<n;i++){
            if(nums[i]>inc_seq[k]){
                k++;
                inc_seq[k]=nums[i];
            }
            else{
                int idx=BS(inc_seq,nums[i],k);
                inc_seq[idx]=nums[i];
            }
        }
       
        return k+1;
    }
    public int BS (int a[],int i,int k){
        int s=0,e=k, ans=k;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(a[mid]>=i){
                ans=mid;
                e=mid-1;
            }
            else
                s=mid+1;
        }
        
        return ans;
    }
}