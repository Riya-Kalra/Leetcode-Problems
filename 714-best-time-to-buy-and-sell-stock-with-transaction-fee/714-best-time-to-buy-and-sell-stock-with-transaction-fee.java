class Solution {
    public int maxProfit(int[] price, int fee) {
        int p=price.length;
        int curr[]=new int[2];
        int after[]=new int[2];
        for(int i=p-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1)
                    curr[1]=Math.max(-price[i]+after[0],after[1]);
                else
                    curr[0]=Math.max(price[i]-fee+after[1],after[0]);
            }
            after=curr;
        }
        return after[1];
        
    }
}
//bsp -1 -1 -1 -1 1 1
//ssp 0 0 0 5 5 8