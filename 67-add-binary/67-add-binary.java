class Solution {
    public String addBinary(String a, String b) {
     int i=a.length()-1,j=b.length()-1;
        int c=0,a1=0,b1=0;
        StringBuilder ans= new StringBuilder();
        while(i>=0 || j>=0){
            if(i>=0)
            a1=a.charAt(i)-'0';
            if(j>=0)
            b1=b.charAt(j)-'0';
            int sum=a1+b1+c;
            c=0;
            if(sum==0)
                ans.append("0");
            else if (sum==1)
                ans.append("1");
            else if (sum==2){
                ans.append("0");
                c=1;
            }
            else{
                ans.append("1");
                c=1;
            }
            a1=0; b1=0;
            i--;
            j--;
        }
        if(c==1)
            ans.append("1");
        return (ans.reverse()).toString();
    }
}