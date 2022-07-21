class Solution {
    List<List<Integer>> ans= new ArrayList<List<Integer>> ();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        func(0,new ArrayList<Integer>(),nums,0);
        
       return ans;
    }
    public void func(int next, ArrayList<Integer> a, int nums[],int size){
      // System.out.println(a +" "+size);
        if(a.size()==size)
            ans.add(new ArrayList<>(a));
       
        for (int i=next;i<nums.length;i++){
            if(i!=next && nums[i]==nums[i-1])
                continue;
            if(i<nums.length){
            a.add(nums[i]);
            }
            
            func(i+1,a,nums,size+1);
            if(a.size()>0)
            a.remove(a.size()-1);
        }
    }
}