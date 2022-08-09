import java.util.*;
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->(b[1]-a[1]));
        int start=0, end=startFuel, cnt=0,i=0,n=stations.length;
        while(end<target){
           while (i < n && stations[i][0] <= end) {
                pq.offer(stations[i++]);
            }
            //System.out.println(Arrays.deepToString(stations));
            if(pq.isEmpty())
                return(-1);
            int t[]=pq.poll();
            //System.out.println(t[0]+" "+t[1]);
            cnt++;
            end+=t[1];
            //System.out.println(end);
        }
        return cnt;
    }
}