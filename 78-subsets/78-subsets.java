class Solution {
     List<List<Integer>> ans= new ArrayList<List<Integer>> ();
    public List<List<Integer>> subsets(int[] nums) {
        
        backtrack(0, new ArrayList<Integer>(), nums,0); 
        return ans;
    }
    public void backtrack(int s,ArrayList<Integer> a, int []n, int i){
        
          
        if(s==n.length){ ans.add(new ArrayList(a));return;}
          // add i into the current combination
          a.add(n[s]);
          // use next integers to complete the combination
          backtrack(s + 1, a, n,i);
          // backtrack
          a.remove(a.size() - 1);
        backtrack(s+ 1, a, n,i);
    }
}