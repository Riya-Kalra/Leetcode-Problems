class Solution {
    List<List<Integer>> ans=new  ArrayList<List<Integer>> ();
    public List<List<Integer>> combinationSum2(int[] A, int target) {
         Arrays.sort(A);
        solve(0, A,target, new ArrayList<Integer> ());
        return ans;
    }
     void solve (int idx,int [] A ,int target, ArrayList<Integer> a){
        if(  target==0){
            ans.add( new ArrayList<Integer> (a));
            return;
        }
        
        for(int i=idx;i<A.length;i++)
        {    
            if(i>idx && A[i]==A[i-1])
                continue;
            if(A[i]>target)
            break;
            a.add(A[i]);
            solve(i+1,A,target-A[i],a);
            a.remove(a.size()-1);
            
        }
        
       
    }
}