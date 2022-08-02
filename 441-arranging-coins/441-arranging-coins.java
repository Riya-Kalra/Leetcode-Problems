class Solution {
    public int arrangeCoins(int n) {
      int require=1, remaining=n;
       while(remaining>=require){
           remaining-=require;
           require++;
       }
        return require-1;
    }
}