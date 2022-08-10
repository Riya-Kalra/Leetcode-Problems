class Solution { 
    List<String> ans=new ArrayList<String>();
    HashSet<String> set = new HashSet<>();
    public List<String> wordBreak(String str, List<String> dict) {
        
        for(int i=0;i<dict.size();i++)
            set.add(dict.get(i));
        dfs(str,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(String str, List<String> temp,int s){
        if(s==str.length()){
            StringBuffer words= new StringBuffer();
            for(int i=0;i<temp.size();i++){
                words.append(temp.get(i)+" ");
            }
            ans.add(words.toString().trim());
            return ;
        }
        for(int i=s;i<str.length();i++){
            if(set.contains(str.substring(s,i+1))){
                temp.add(str.substring(s,i+1));
                dfs(str,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}