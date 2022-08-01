class Solution {
    int copy[];
    int original[];
    public Solution(int[] nums) {
        copy=nums;
        original=nums.clone();
    }
    
    public int[] reset() {
        copy=original;
         original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
      for (int i = 0; i < copy.length; i++) {
            swapAt(i, randRange(i, copy.length));
        }
        return copy;  
    }
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = copy[i];
        copy[i] = copy[j];
        copy[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */