class Solution {
    public int[] plusOne(int[] d) {
        StringBuilder s= new StringBuilder();
        int c=1,n=d.length;
        for(int i=n-1;i>=0;i--){
            s.append(Integer.toString((d[i]+c)%10));
            c=(d[i]+c)/10;
        }
        if(c>0)
            s.append(Integer.toString(c));
        
        int n1=s.length();
        int a[]=new int[n1];
        for (int i=0;i<n1;i++)
            a[n1-1-i]=s.charAt(i)-'0';
        
        return a;
    }
}