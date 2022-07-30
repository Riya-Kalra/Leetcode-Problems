class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n]; //stores the len of Inc. Subsequence
        int count[]=new int[n];
        int max=0; //store the len of longest lis
        
        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&& dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                }
                else if(arr[i]>arr[j]&& dp[i]==dp[j]+1){
                    count[i]+=count[j];
                }
            }
            max=Math.max(max,dp[i]);
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)
                ans+=count[i];
        }
        return ans;
    }
}