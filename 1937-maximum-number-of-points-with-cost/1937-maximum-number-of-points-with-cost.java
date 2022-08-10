class Solution {
    public long maxPoints(int[][] points) {
        int n=points.length,m=points[0].length;
        long prev[]=new long[m];
        long max=Long.MIN_VALUE;
        for(int i=0;i<m;i++){
            max=Math.max(max,points[0][i]);
            prev[i]=points[0][i];
        }
        long ans=max;
        for(int i=1;i<n;i++){
            long[] left = new long[m], right = new long[m], dp = new long[m];
            left[0] = prev[0];
            right[m - 1] = prev[m - 1];
            for (int j = 1; j < m; ++j)
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            for (int j = m-2; j>=0; j--)
                right[j] = Math.max(right[j+1] - 1, prev[j]);
            
            for(int j=0;j<m;j++){
                dp[j]=points[i][j]+Math.max(left[j],right[j]);
                if(i==n-1)
                    ans=Math.max(ans,dp[j]);   
            }
            prev=dp.clone();
        }
            
        //System.out.println(Arrays.deepToString(points));
        return ans;
    }
}