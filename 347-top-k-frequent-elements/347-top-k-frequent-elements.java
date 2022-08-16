class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap <>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue< int[]> pq= new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(Integer key: map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        int ans[]= new int [k];
        int i=0;
        while( k-->0){
            ans[i++]=pq.poll()[0];
        }
        return ans;
    }
}