class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m=l.length,n=nums.length;
        List<Boolean>  ans= new ArrayList<Boolean> ();
        for(int i=0;i<m;i++){
            int x=l[i], y=r[i];
            int b[] = Arrays.copyOfRange(nums, x, y+1);
            Arrays.sort(b);
            int d=b[1]-b[0], f=0;
            for(int j=1;j<b.length;j++){
                if(b[j]-b[j-1]!=d)
                {
                    ans.add(false);
                    f=1;break;
                }
            }
            if(f==0)
            ans.add(true);
        }
        return ans;
    }
}