class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int t[]=new int[target+1];
            t[0]=1;
        
        for (int i=1;i<target+1;i++)
            for (int num : nums)
                if (num <= i)
                    t[i] += t[i-num];
      
        return t[target];
    }
}