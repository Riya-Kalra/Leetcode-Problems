class Solution {
    public int minSetSize(int[] arr) {
        HashMap <Integer,Integer> map =new HashMap<>();
        int n= arr.length;
        for(int i=0;i<n;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->(b-a));
        for(Integer key : map.keySet()){
            pq.add(map.get(key));
        }
        int sum=0, c=0;
        while(!pq.isEmpty()){
            int a=pq.poll();
            sum+=a;
            c++;
            if(sum>=n/2)
                return c;
        }
        return c;
    }
}