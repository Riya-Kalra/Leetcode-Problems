class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<=Math.min(nums.length-1,k);i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        for(int j=k+1;j<nums.length;j++){
            set.remove(nums[j-k-1]);
            if(set.contains(nums[j]))
                return true;
            set.add(nums[j]);
            
        }
        return false;
    }
}