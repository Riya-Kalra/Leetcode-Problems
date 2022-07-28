class Solution {
    public int[] findOrder(int A ,int[][] B) {
        ArrayList<ArrayList<Integer>> adj= new  ArrayList<ArrayList<Integer>> ();
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<Integer> ());
        }
        for(int i=0;i<B.length;i++){
            (adj.get(B[i][0])).add(B[i][1]);
        }
        int vis[]=new int[A];
        int dfsvis[]=new int[A];
        
        for(int i=0 ;i<A;i++){
            if(vis[i]==0){//if for any node cycle exist 
                if (dfs(i,vis,dfsvis,adj))
                return (new int[]{});
            }
        }
        int a[]=new int [ans.size()];
        for(int i=0;i<ans.size();i++)
            a[i]=ans.get(i);
        return a;
    }
    ArrayList<Integer> ans= new ArrayList<Integer>();
    public boolean dfs(int i,int vis[],int dfsvis[],ArrayList<ArrayList<Integer>> adj){
        vis[i]=1;
        dfsvis[i]=1;
        for(int j:adj.get(i)){
            if(dfsvis[j]==1)
                return true;
            else if(vis[j]==0)
                if (dfs(j,vis,dfsvis,adj))
                return true;
        }
        ans.add(i);
        dfsvis[i]=0;
        return false;
    }
}