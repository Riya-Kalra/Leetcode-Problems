class Solution {
    public int firstMissingPositive(int[] nums) {
        TreeSet <Integer> set = new TreeSet<>();
        for(int n: nums)
            if(n>0)
            set.add(n);
        int i=1;
        while(true){
            if(set.contains(i))
                i++;
            else
                return i;
        }
        
    }
}