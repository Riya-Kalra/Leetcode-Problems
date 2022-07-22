class Solution {
    List<List<Integer>> ans=new  ArrayList<List<Integer>> ();
    public List<List<Integer>> combinationSum(int[] can, int target) {
        int n=can.length;
         //Arrays.sort(can);
        solve(0, can,target, new ArrayList<Integer> ());
        return ans;
    }
    void solve (int i, int can[],int target, ArrayList<Integer> a){
        if( target==0){
            ans.add( new ArrayList<Integer> (a));
            return;
        }
        if(i>=can.length )
            return;
        if(can[i]<=target )
        {    
            a.add(can[i]);
            solve(i,can,target-can[i],a);
            a.remove(a.size()-1);
        }
        solve(i+1,can,target,a);
       
    }
}