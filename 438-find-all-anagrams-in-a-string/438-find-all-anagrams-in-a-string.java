class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> maps=new HashMap<>();
        List<Integer> ans= new ArrayList<Integer>();
        if(s.length()<p.length()) 
            return ans;
        for (int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
            maps.put(s.charAt(i),maps.getOrDefault(s.charAt(i),0)+1);
        }
        
        if(maps.equals(map))
                ans.add(0);
        for (int i=p.length();i<s.length();i++){
            maps.put(s.charAt(i),maps.getOrDefault(s.charAt(i),0)+1);
            int x=i-p.length();
            maps.put(s.charAt(x),maps.getOrDefault(s.charAt(x),0)-1);
            if(maps.get(s.charAt(x))<=0)
                maps.remove(s.charAt(x));
            if(maps.equals(map))
                ans.add(x+1);
        }
        return ans;
    }
}