class Solution {
    List<List<Integer>> arr= new ArrayList<>();
    int vis[];
    public List<List<Integer>> allPathsSourceTarget(int[][] g) {
        int dest=g.length-1;
        vis=new int[g.length];
        dfs(0,g,dest,new ArrayList<Integer>());
        return arr;   
    }
    void dfs(int i,int g[][],int dest,ArrayList<Integer> a ){
        vis[i]=1;
        a.add(i);
        if(i==dest){
            arr.add(new ArrayList<Integer> (a) ); 
        }
        for (int j: g[i]){
            
            if(vis[j]==0){
                dfs(j,g,dest,a);
            }
        }
        vis[i]=0;
        a.remove(a.size()-1);
    }
    
}