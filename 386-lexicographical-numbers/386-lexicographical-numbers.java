class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
         
        for(int i=1;i<=9;i++){
            dfs(i,n);
        }
        return ans;
    }
    public void dfs(int val,int n){
        if(val>n)
            return;
        else if(val==n){
            ans.add(val);
            return;
        }
        else{
            ans.add(val);
            for(int i=0;i<=9;i++){
                dfs(val*10+i,n);
            }
        }
    }
}