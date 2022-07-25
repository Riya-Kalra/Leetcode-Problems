class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
      int rs=0,cs=0,n=mat.length,m=mat[0].length,re=n-1,ce=m-1,c=1;
        List<Integer> list= new ArrayList<Integer>();
        while(c<=n*m){
            for(int i=cs;i<=ce && c<=n*m;i++){
                list.add(mat[rs][i]);
                c++;
            }
            rs++;
            for(int i=rs;i<=re && c<=n*m;i++){
                list.add(mat[i][ce]);
                c++;
            }
            ce--;
            for(int i=ce;i>=cs && c<=n*m;i--){
                list.add(mat[re][i]);
                c++;
            }
            re--;
            for(int i=re;i>=rs && c<=n*m;i--){
                list.add(mat[i][cs]);
                c++;
            }
            cs++;
        }
        return list;
    }
}