class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map =new HashMap<>();
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        //System.out.println(map);
        int sum=0,max=0,f=0;
        for(String s:map.keySet()){
            String rev="";
            rev+=s.charAt(1);
            rev+=s.charAt(0);
            //System.out.println(rev+" "+s+" "+map.get(s));
            if(rev.equals(s)){
                int c=map.get(s);
                if( c%2==1){
                    c-=1;
                    if(f==0){
                        max+=1;
                        f=1;
                    }
                }
                max+=c;
            }
            else
            {
                
                if(map.containsKey(rev)){
                    sum+=2*Math.min(map.get(rev),map.get(s));
                
                }
            }
           // System.out.println(sum+" "+max);
        }
        
        return sum+2*max;
    }
}