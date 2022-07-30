class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len= s.length();
        int t[]=new int[len];
        for (int i=0;i<len;i++){
            for (int j=0;j<=i;j++){
                String word=s.substring(j,i+1);
                if (wordDict.contains(word)){
                    if (j>0){
                        t[i]+=t[j-1];
                    }
                    else
                        t[i]+=1;
                }
            }
        }
        //System.out.println(Arrays.toString(t));
        return (t[len-1]>0);
    }
}