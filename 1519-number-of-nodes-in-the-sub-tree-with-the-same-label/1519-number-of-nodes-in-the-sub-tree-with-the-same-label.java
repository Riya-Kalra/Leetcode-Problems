class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] ans = new int[n];
        dfs(adj, 0,-1, labels, ans);
        return ans;
    }
    public int[] dfs( ArrayList<ArrayList<Integer>> adj, int ind, int parent,  String labels, int ans[] ){
       
        int cnt[]= new int[26];
        char c=labels.charAt(ind);
        for(Integer id: adj.get(ind)){
            if(id!=parent){
                int cal[]=dfs(adj,id,ind,labels,ans);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += cal[i];
                }
            }  
        }
        cnt[c - 'a']++;
        ans[ind]=cnt[c-'a'];
        return cnt;
    }
}