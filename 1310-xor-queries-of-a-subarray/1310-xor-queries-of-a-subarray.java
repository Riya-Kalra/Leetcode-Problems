class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n=arr.length;
        int ans[]=new int[q.length];
        int prefix_xor[]= new int [n+1];
        
        for(int i=1;i<=n;i++){
            prefix_xor[i]= prefix_xor[i-1]^arr[i-1];
        }
       // System.out.println(Arrays.toString( prefix_xor));
        for(int i=0;i<q.length;i++){
            int s=q[i][0],e=q[i][1];
            ans[i]= prefix_xor[e+1]^ prefix_xor[s];
        }
        return ans;
    }
}