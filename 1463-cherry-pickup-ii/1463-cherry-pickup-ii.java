class Solution {
    int n,m;
    int t[][][];
    int grid[][];
    public int cherryPickup(int[][] grid) {
         n=grid.length;
         m=grid[0].length;
        this.grid=grid;
        t=new int[n][m][m];
        for(int a[][]:t){
            for(int r[]:a)
                Arrays.fill(r,-1);
        }
        return solve(0,0,m-1);
    }
    public int solve(int i, int c1,int c2){
        //System.out.println(i+" "+c1+" "+c2+" "+t[i][c1][c2]);
        if(c1<0 || c2<0||c1>=m ||c2>=m )
            return -9999999;
        if(i==n-1){
            if(c1==c2)
                return grid[i][c1];
            else
                return grid[i][c1]+grid[i][c2];
        }
        int max=0;
        if(t[i][c1][c2]!=-1) return t[i][c1][c2];
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
              if(c1==c2)
                 max=Math.max(max,solve(i+1,c1+x,c2+y)+grid[i][c1]);
              else
                 max=Math.max(max,solve(i+1,c1+x,c2+y)+grid[i][c1]+grid[i][c2]);   
            }
        }
        t[i][c1][c2]=max;
        return max;
    }
}