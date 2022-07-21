class Solution {
    int[][][] memo;
    int N;
    public int cherryPickup(int[][] grid) {
        N=grid.length;
        memo = new int[N][N][N];
        for (int[][] layer: memo)
            for (int[] row: layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        return Math.max(0, solve(0, 0, 0,grid));
    }
    public int solve(int r1,int c1,int c2, int[][] g){
        int r2 = r1 + c1 - c2;
        if (N == r1 || N == r2 || N == c1 || N == c2 || g[r1][c1] == -1 || g[r2][c2] == -1) {
            return -999999;        
        } else if (r1 == N-1 && c1 == N-1) {
            return g[r1][c1];
        } else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        } else {
            int ans = g[r1][c1];
            if (c1 != c2) ans += g[r2][c2];
            
            ans += Math.max(Math.max(solve(r1, c1+1, c2+1,g), solve(r1+1, c1, c2+1,g)),Math.max(solve(r1, c1+1, c2,g), solve(r1+1, c1, c2,g)));
            
            memo[r1][c1][c2] = ans;
            return ans;
        }
    }
}