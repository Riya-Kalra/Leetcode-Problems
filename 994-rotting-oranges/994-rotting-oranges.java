class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q =new LinkedList<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2 )
                    q.add(new int[]{i,j});
                else if(grid[i][j]==1)
                    count++;
            }
        }
        if(count==0) return 0;
        int x[]={-1,0,1,0};
        int y[]={0,1,0,-1};
        int level=-1,c=0;
        while(!q.isEmpty()){
            int sz=q.size();
            level++;
            for(int z=0;z<sz;z++){
                int t[]=q.poll();
                for(int k=0;k<4;k++){
                    int i=x[k]+t[0];
                    int j=y[k]+t[1];
                    if(i<grid.length && j<grid[0].length && i>=0 && j>=0 && grid[i][j]==1){
                        grid[i][j]=2;
                        q.add(new int[]{i,j});
                        c++;
                    }       
                }
                
            }
        }
        //System.out.println(c+" "+count);
        if(c==count)
        return level;
        return -1;
    }
}