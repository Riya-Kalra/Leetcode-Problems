class Solution {
    public int firstMissingPositive(int[] nums) {
        TreeMap <Integer,Integer> map = new TreeMap<>();
        for(int n: nums)
            map.put(n,map.getOrDefault(n,0)+1);
        int i=1;
        while(true){
            if(map.containsKey(i))
                i++;
            else
                return i;
        }
        
    }
}