class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->(b[0]-a[0]));
        int n=nums.length;
        int ans[]= new int[n-k+1];
        int j=0;
        for(int i=0;i<k-1;i++)
            pq.add(new int[]{nums[i],i});
        for(int i=k-1;i<n;i++){
            while(!pq.isEmpty() && pq.peek()[1]<=i-k){
                pq.poll();
            }
            pq.add(new int[]{nums[i],i});
            int t[]=pq.peek();
            
            //System.out.println(pq.toString());
            ans[j++]=t[0];
        }
        return ans;
    }
}