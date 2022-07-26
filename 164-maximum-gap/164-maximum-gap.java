class Solution {
    public int maximumGap(int[] nums) {
        int n=nums.length;
        if(n<2) return 0;
         int max=nums[0]; 
		for(int i=1;i<nums.length;i++)
		 { if(nums[i]>max)
			 max=nums[i];
		 }
		
	      int res[]=new int[nums.length]; //result array
	    
	      //Arrays.fill(count, 0);
	      int exp= 1; //10,100,1000... to scan the digits from lsb to msb
	      
      while(max / exp > 0)  //when this becomes 0,means we have move ahead of msb now
      {  int count[]=new int[10]; 
	      for(int i=0;i<nums.length;i++)
	      {
	    	  
	    	  count[(nums[i] /exp) % 10]++;  //incrementing the count array
	      }
	       
	      for(int i=1;i<10;i++)
	      {  
	    	  count[i]+=count[i-1];   //cumulative frequency count array
	      }
	      
	      for(int i=nums.length-1;i>=0;i--)  //start looping from the end of array
	      {
	    	  res[count[(nums[i]/exp)%10]-1]=nums[i];   
	    	  count[(nums[i]/exp)%10]--;     //decrementing frequency in count array
	      }
	      
	      for(int i=0;i<nums.length;i++)
	      {
	    	   nums[i]=res[i];    //for the next pass resultant array will be input
	      }
	      exp*=10;
      }
        
        int m=0;
        for(int i=1;i<nums.length;i++)
        {
            m=Math.max(m,nums[i]-nums[i-1]);
        }
        return m;
	  
        
    }
}