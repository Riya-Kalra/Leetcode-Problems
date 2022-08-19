class Solution {
    public int firstMissingPositive(int[] nums) {
        
        //Smallest missing positive integer could nums.length+1
        int count[]=new int[nums.length+1];
        for(int n: nums)
            if(n>0 && n<=nums.length)
            count[n]+=1;
        
        for(int i= 1 ;i<count.length;i++){
            if(count[i]==0)
                return i;
        }
        return nums.length+1;
    }
}