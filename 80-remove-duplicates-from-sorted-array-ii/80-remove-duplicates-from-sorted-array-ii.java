class Solution {
    public int removeDuplicates(int[] a) {
        int n=a.length;
        int i=-1,j=0;
        while(j<n){
            if(i==-1 || a[j]!=a[i]){
                a[++i]=a[j];
            if(j+1 <n && a[j]==a[j+1] )
                a[++i]=a[j++];
            }
            j++;
        }
        return i+1;
    }
}