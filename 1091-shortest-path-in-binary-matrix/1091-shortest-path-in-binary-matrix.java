class Solution {
    int dir[][]={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(grid[0][0]==1|| grid[n-1][m-1]==1) return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        grid[0][0]=1;
        while(q.size()>0){
            int s=q.size();
            for (int k=0;k<s;k++){
                int a[]=q.poll();
                for(int d[]:dir){
                    int i=a[0]+d[0]; int j=a[1]+d[1];
                     if(i>=0 && j>=0 && i<n && j<m && grid[i][j]==0 ){
                     grid[i][j]=1+grid[a[0]][a[1]];
                     q.add(new int[]{i,j});}
                }
            }
        }
        if(grid[n-1][m-1]==0)
            return -1;
        return (grid[n-1][m-1]);
        
    }
    
}