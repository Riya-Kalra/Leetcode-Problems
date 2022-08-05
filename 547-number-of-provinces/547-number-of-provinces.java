class Solution {
    int parent[];
    int size[];
     int count;
    public int findCircleNum(int[][] a) {
        int n=a.length;
        count=n;
        parent= new int[n];
        size= new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<a.length;i++)
        {
            for (int j=0;j<=i;j++){
                if(a[i][j]==1){
                    union(i,j);
                }
            }
        }
        return count;
    }
    public int findParent(int node){
        if(parent[node]==node)
            return node;
        return findParent(parent[node]);
    }
    public void union(int u,int v){
        int rootu=findParent(u);
        int rootv=findParent(v);
        System.out.println(u + " " + v+" "+count);
        if(rootu==rootv)
            return ;
        if(size[rootu]> size[rootv]) {
                parent[rootv] = rootu;
                size[rootu] += size[rootv];
        } 
        else {
                parent[rootu] = rootv;
                size[rootv] += size[rootu];
        }
        //System.out.println(u + " " + v+" "+count);
        count--;
    }
}