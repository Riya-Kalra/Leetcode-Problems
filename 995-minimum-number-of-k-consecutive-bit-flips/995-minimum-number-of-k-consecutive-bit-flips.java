class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flipcount=0,result=0,n=nums.length;
        boolean flip[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(i>=k){
                if(flip[i-k]==true)
                    flipcount--;
            }
            if(flipcount%2==nums[i]){
                flip[i]=true;
                flipcount++;
                result++;
                if(i+k>n)
                    return -1;
            }
        }
        return result;
    }
}