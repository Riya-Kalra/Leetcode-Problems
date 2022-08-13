class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length>s.length())
            return new ArrayList<Integer>();
        List<Integer> ans=new ArrayList<Integer> ();
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<words.length;i++)
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        
        int k=words[0].length(), n=words.length, c=0;
        
        for(int i=0;i<=s.length()-n*k;i++){
             HashMap<String,Integer> seen= new HashMap<>();
             for(int j=0;j<n;j++){
                 int index=i+j*k;
                 String word=s.substring(index,index+k);
                 if(!map.containsKey(word))
                     break;
                 seen.put(word,seen.getOrDefault(word,0)+1);
                 if(map.getOrDefault(word,0)<seen.get(word))
                     break;
                 if(j==n-1)
                     ans.add(i);
                     
             }
        }
        return ans;
    }
}