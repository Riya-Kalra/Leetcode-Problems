class Solution {
    public int longestSubstring(String s, int k) {
        int len=00;
        for(int j=0;j<s.length();j++){
            int count[]= new int[26];
            for(int i=j;i<s.length();i++){
                char ch= s.charAt(i);
                count[ch-'a']++;
                if(isValid(count,k))
                    len=Math.max(len,i-j+1);

            }
        }
        return len;
    }
    boolean isValid(int count[],int k){
        for(int i=0;i<26;i++){
            if(count[i]>0 && count[i]<k)
                return false;
        }
        return true;
    }
}