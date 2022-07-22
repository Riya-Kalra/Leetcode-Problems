class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> temp, int [] nums, boolean [] used){
    if(temp.size() == nums.length){
        list.add(new ArrayList<>(temp));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) )continue;
            used[i] = true; 
            temp.add(nums[i]);
            backtrack(list, temp, nums, used);
            used[i] = false; 
            temp.remove(temp.size() - 1);
        }
    }
}
}