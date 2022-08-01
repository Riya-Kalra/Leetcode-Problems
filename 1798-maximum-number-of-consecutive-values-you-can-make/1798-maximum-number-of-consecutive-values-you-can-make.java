class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int n=coins.length;
         int sum = 1;
        for(int i=0;i<n;i++){
            if(coins[i]>sum) 
                break;
            sum=sum+coins[i];
        }
        return sum;
    }
}