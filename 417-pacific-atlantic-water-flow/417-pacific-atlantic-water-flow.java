class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int n=h.length,m=h[0].length;
        List<List<Integer>> res=new ArrayList<List<Integer>> ();
        if(n==0 || m==0) return res;
        boolean pacific [][]=new boolean[n][m];
        boolean atlantic [][]=new boolean[n][m];
         for(int i = 0; i < m; i++){
            dfs(h, 0, i, Integer.MIN_VALUE, pacific);//Water can easily flow from 0th row to pacific therefore starting dfs from it traversing all cell greater then them as water can flow from those cell to this cell
            dfs(h, n-1, i, Integer.MIN_VALUE, atlantic);
        }
        
        for(int i = 0; i < n; i++){
            dfs(h, i, 0, Integer.MIN_VALUE, pacific);
            dfs(h, i, m-1, Integer.MIN_VALUE, atlantic);
        }
        
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(pacific[i][j]==true && atlantic[i][j]==true){
                   // System.out.println(Arrays.asList(i,j));
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    
    int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
     public void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean){
        if(i >= 0 && i< ocean.length && j >= 0 && j < ocean[0].length && matrix[i][j] >= prev && ocean[i][j]==false ) 
        {
            //System.out.println(Arrays.asList(i,j));
            ocean[i][j] = true;
            for(int[] d : dir){
                dfs(matrix, i+d[0], j+d[1], matrix[i][j], ocean);
            }
        }
    }
}