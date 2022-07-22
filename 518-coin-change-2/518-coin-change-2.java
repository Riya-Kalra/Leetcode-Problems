class Solution {
    public int change(int a, int[] coins) {
        int n=coins.length;
        int prev[]=new int[a+1];
        
        for (int j=0;j<a+1;j++){
            if (j%coins[0]==0)
                prev[j]=1;
            else
                prev[j]=0;
        }
        int curr[]=new int[a+1];
        for (int i=1;i<n;i++){
            
            for (int j=0;j<a+1;j++){
                int not_pick=prev[j];
                int pick=0;
                if (coins[i]<=j)
                   pick=curr[j-coins[i]];
                curr[j]=pick+not_pick;
            }
              prev=curr;  
            //System.out.println(Arrays.toString(t));
        }
        
        return prev[a];
    }
}