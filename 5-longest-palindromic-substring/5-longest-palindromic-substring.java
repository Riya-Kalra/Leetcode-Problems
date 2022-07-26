class Solution {
    public String longestPalindrome(String s) {
         if (s == null || "".equals(s)) {
            return s;
        }
        
        int len = s.length();

        String ans = "";
        int max = 0,start=0,end=0;

        for (int j = 0; j < len; j++) {
            int l1=expand(s,j,j);
            int l2=expand(s,j,j+1);
            max= Math.max(l1,l2);
            if(max>end-start){
                start=j-(max-1)/2;
                end=j+(max)/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int expand(String s, int left,int right){
        int n=s.length();
        if (s==null || left>right)return 0;
        while( left>=0 && right <n && s.charAt(left)==s.charAt(right))
            {
               left--;
               right++;
            } 
        
        return (right-left-1);
    }
}