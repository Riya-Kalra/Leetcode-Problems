class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
       PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)->((a[0]==b[0])? a[1]-b[1]:a[0]-b[0]));
        TreeMap<Integer,ArrayList<int[]>> map = new TreeMap<>();
        int n=tasks.length;
        int [] ans =new int[n];
        for(int i=0;i<servers.length;i++){
            int a[]= {servers[i],i};
            pq.add(a);
        }
        int time=0,i=0;
        while(i<n){
           // System.out.println(map.toString()+" "+i);
            time = Math.max(time, i);
            
            if(map.containsKey(time)){
                ArrayList<int[]>t=map.get(time);
                for(int [] arr:t)
                    pq.add(arr);
                map.remove(time);
            }
             if(pq.isEmpty()){
                time = map.firstKey();
                pq.addAll(map.get(time));
                map.remove(time);
            }   
            
                int a[]=pq.poll();
                ans[i]=a[1];
                ArrayList <int[]> temp= map.getOrDefault(time+tasks[i],new ArrayList<int[]>());
                temp.add(a);
                map.put(time+tasks[i],temp);
                i++;
        }
        return ans;
    }
}