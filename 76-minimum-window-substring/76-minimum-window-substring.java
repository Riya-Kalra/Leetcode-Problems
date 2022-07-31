class Solution {
    public String minWindow(String s, String t) {
        int l1=s.length(),l2=t.length();
        if (l1 == 0 || l2== 0 || l2>l1) {
            return "";
        }
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0;i<l2;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int count=map.size();
        int start=0,end=0,minLen=Integer.MAX_VALUE,minstart=-1,minend=-1;
        while(end<s.length()){
          char c=s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                count--;
            }
            while(count==0){//i.e., all the characters are found
                if(minLen>end-start+1){
                    minLen=end-start+1;
                    minstart=start;
                    minend=end+1;
                }
                char tempCharStart = s.charAt(start);//moving the start pointer 
                if (map.containsKey(tempCharStart)) {
                        map.put(tempCharStart, map.get(tempCharStart) + 1);
                        if (map.get(tempCharStart) > 0) 
                            count++;
                    }
                    start++;
            }
            end++;
        }
        if(minLen==Integer.MAX_VALUE)
                return "";
        return(s.substring(minstart,minend));
    }
}