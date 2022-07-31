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
    public void dfs(int edges[],int i,int vis[],int c,HashMap<Integer,Integer> currVis){
        
        vis[i] = 1;
        currVis.put(i,c);
        // go to adjacent node...
        int ele = edges[i];
        if(ele == -1) return;
        if(currVis.containsKey(ele)){ // already visited and cycle..
            cycle = Math.max(cycle, (c+1)-currVis.get(ele));
        }
        else if(vis[ele] == -1){
            dfs(edges,ele, vis,c+1,currVis);
        }     
        
    }
}