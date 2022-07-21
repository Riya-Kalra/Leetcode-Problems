class Solution {
     List<List<Integer>> ans= new ArrayList<List<Integer>> ();
    public List<List<Integer>> subsets(int[] nums) {
        
        backtrack(0, new ArrayList<Integer>(), nums,0); 
        return ans;
    }
    public void backtrack(int s,ArrayList<Integer> a, int []n, int i){
        
          ans.add(new ArrayList(a));
         
        for (int j = s; j < n.length; j++) {
          // add i into the current combination
          a.add(n[j]);
          // use next integers to complete the combination
          backtrack(j + 1, a, n,i);
          // backtrack
          a.remove(a.size() - 1);
        }
    }
}