class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0,r=0,max=0;
        HashMap<Character,Integer> map= new HashMap<>();
        while(r<n){
            char ch=s.charAt(r);
            if(map.containsKey(ch))
            {
                l=Math.max(l,map.get(ch)+1);   
            }
            max=Math.max(max,r-l+1);
            map.put(ch,r);
            r++;
            //System.out.println(ch+" "+max+);
        }
        max=Math.max(max,r-l);
        return max;
    }
}