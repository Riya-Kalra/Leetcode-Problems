class Solution {
    public int lengthOfLastWord(String s) {
        
        
        int n=s.length()-1;
        
        while(n>=0 && s.charAt(n)==' ')
            n--;
        //System.out.println(s.substring(0,n+1)+'*');
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==' ')
                return (n-i);
        }
        return n+1;
    }
}