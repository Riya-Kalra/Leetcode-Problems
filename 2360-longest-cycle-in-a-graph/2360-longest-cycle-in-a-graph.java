class Solution {
    int cycle=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int vis[]=new int[n];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
               HashMap<Integer,Integer> dfsvis=new HashMap<>();
                
                dfs(edges,i,vis,0,dfsvis);
            }
        }
        return cycle;
    }
    public void dfs(int edges[],int i,int vis[],int c,HashMap<Integer,Integer> dfsvis){
       if(i==-1) return;
        if(dfsvis.containsKey(i))
            cycle=Math.max(cycle,c-dfsvis.get(i));
        else if(vis[i] == -1){
            dfsvis.put(i,c);
            vis[i]=1;
            dfs(edges,edges[i],vis,c+1,dfsvis);
        }
    }
}