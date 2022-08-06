class Solution {
    List<List<Integer>> ans= new ArrayList<List<Integer>> ();
    public List<List<Integer>> permute(int[] nums) {
        perm(0,nums);
        return ans;
    }
    public void perm(int i,int []nums){
        if(i==nums.length){
             List<Integer> list = Arrays.stream(nums)        // IntStream
                                    .boxed()          // Stream<Integer>
                                    .collect(Collectors.toList());  
            ans.add(list);
            return;
        }
        
        for(int j=i;j<nums.length;j++){
            swap(i,j,nums);
            perm(i+1,nums);
            swap(i,j,nums);
        }
    }
     static void swap(int i, int j,int s[]) {
        int ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}