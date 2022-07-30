class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans= new ArrayList<String>();
        int freq1[]=new int [26];
        
        for(String w2:words2){
            int freq[]= countFreq(w2);
            for(int i=0;i<26;i++){
                freq1[i]=Math.max(freq[i],freq1[i]);
            }
        }
        for(String w1:words1){
            int freq2[]= countFreq(w1);
            int f=0;
            for(int i=0;i<26;i++){
                if(freq2[i]>=freq1[i])
                    continue;
                else{
                    f=1;
                    break;
                }
            }
            if(f==0)
                ans.add(w1);
        }
        
        return ans;
    }
    public int []  countFreq(String w){
        int freq[]=new int [26];
        for(int i=0;i<w.length();i++ ){
            freq[w.charAt(i)-'a']++;
        }
        return freq;
    }
}