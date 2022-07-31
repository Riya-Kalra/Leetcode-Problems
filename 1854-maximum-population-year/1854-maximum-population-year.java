class Solution {
    public int maximumPopulation(int[][] logs) {
        int year[]= new int[100];
        int ans=2051,max=0;
        for(int i=0;i<logs.length;i++){
            for(int j=logs[i][0];j<logs[i][1];j++){
                year[j-1950]+=1;
                if(year[j-1950]>=max){
                    
                    if(max==year[j-1950])
                        ans=Math.min(j,ans);
                    else
                        ans=j;
                    max=year[j-1950];
                }
            }
        }
        return ans;
    }
}