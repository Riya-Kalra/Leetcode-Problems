class Solution {
    public int nextGreaterElement(int n1) {
        String s=String.valueOf(n1);
        char ch[]= s.toCharArray();
        int n=s.length();
        
        String sb="";
        int i;
        for(i=n-2;i>=0;i--){
            if(ch[i]<ch[i+1])
            {
                break;
            }
        }
        
        if(i==-1)
            return -1;
        int k = ch.length-1;
        while(ch[k] <= ch[i])
            k--;
        //System.out.println(i+" "+ind);
        char t=ch[i];
        ch[i]=ch[k];
        ch[k]=t;
        //System.out.println(Arrays.toString(ch));
        Arrays.sort(ch,i+1,n);
        String ans=String.valueOf(ch);
        long x=Long.parseLong(ans);
        if(x<=Integer.MAX_VALUE)
        return(Integer.parseInt(ans));
        else
            return -1;
    }
}
//12345
//12354
//12453
//230241
