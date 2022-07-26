class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2) return 0;
         int max=nums[0]; 
		for(int i=1;i<n;i++)
		 { if(nums[i]>max)
			 max=nums[i];
		 }
		
	      int res[]=new int[n];
	      int exp= 1; //10,100,1000... to scan the digits from lsb to msb
        while(max/exp>0){
            int cnt[]=new int[10];
            for(int i=0;i<n;i++)
	    	  cnt[(nums[i] /exp) % 10]++; //to get the digit 
            for(int i=1;i<10;i++)
                cnt[i]+=cnt[i-1];
            for(int i=n-1;i>=0;i--){
                res[cnt[(nums[i]/exp)%10]-1]=nums[i];
                cnt[(nums[i]/exp)%10]--;
            }
	        for(int i=0;i<n;i++){
                nums[i]=res[i];
            }
	       exp*=10;
            
        }
	      int diff=0;
        for(int i=1;i<n;i++)
        {
            diff=Math.max(diff,nums[i]-nums[i-1]);
        }
        return diff;
    
    }
}