class Solution {
    ArrayList<Integer> ans =new ArrayList<>();
    int k;
    public int[] numsSameConsecDiff(int n, int k) {
        this.k=k;
        for(int i=1;i<=9;i++){
            dfs(i,n-1);   
        }
        int result[]=new int[ans.size()];
        
        for(int i=0; i<ans.size(); i++)
            result[i]=ans.get(i);
        return result;
    }
    void dfs(int prev,int len){
        if(len==0){
           ans.add(prev);
            return;
        }
        int last=prev%10;
        
        if(k!=0 && last-k<=9 && last-k>=0){
            int no= prev*10+ last-k;
            dfs(no,len-1);
        }
        
        if(last+k<=9 && last+k>=0){
            int no= prev*10+ last+k;
            dfs(no,len-1);
        }
        
        
            
    }          
}