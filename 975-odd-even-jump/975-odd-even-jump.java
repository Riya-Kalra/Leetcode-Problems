class Solution {
    public int oddEvenJumps(int[] arr) {
        int n=arr.length;
        Integer odd[]=new Integer[n];
        Integer even[]= new Integer[n];
        Integer index[]= new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        } 
        Arrays.sort(index,(a,b)->arr[a]-arr[b]);
        
        NGE(index,odd);
        Arrays.sort(index,(a,b)->arr[b]-arr[a]);
        NGE(index,even);
       //for(int i = 0; i < n; i++){
       //    System.out.println(odd[i] + " " + even[i]);
       //}
        int dp[][]= new int[n][2];
        dp[n-1][0]=1;
        dp[n-1][1]=1;
        int sum=1;
        for(int i=n-2;i>=0;i--){
            if(odd[i]!=null)
            dp[i][0] = dp[odd[i]][1];
            if(even[i]!=null)
            dp[i][1] = dp[even[i]][0];
            sum+=dp[i][0];
        }
        return sum;
        
    }
    public void NGE( Integer index[],Integer arr[]){
        Stack <Integer> stk= new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stk.isEmpty() && stk.peek()<index[i]){
                arr[stk.pop()] = index[i];
            }
            stk.add(index[i]);
        }
    }
    public void reverse(Integer a[]){
        for(int i=0;i<a.length/2;i++){
            int t=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=t;
        }
    }
}