class Solution {
    List<List<Integer>> ans=new ArrayList<List<Integer>> ();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        comb(0,candidates,target,new ArrayList<Integer>());
        return ans;
    }
    public void comb(int i,int[]can,int target,List<Integer> a){
        if(target==0){
            ans.add(new ArrayList<Integer>(a));
            return;
        }
        if(i>= can.length || target<0)
            return;
        a.add(can[i]);
        comb(i,can,target-can[i],a);
        a.remove(a.size()-1);
        comb(i+1,can,target,a);
    }
}