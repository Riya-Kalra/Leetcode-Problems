class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length; 
        int a[]=new int[n];
        int i=0,j=0;
        while(i<n){
            if(arr[j]==0)
                a[i++]=0;
            if(i<n)
            a[i++]=arr[j];
            j++;
        }
        for(i=0;i<n;i++)
        arr[i]=a[i];
    }
}