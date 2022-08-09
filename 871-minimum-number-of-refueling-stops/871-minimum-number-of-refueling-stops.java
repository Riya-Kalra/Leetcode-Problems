import java.util.*;
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->(b[1]-a[1]));
        int start=0, end=startFuel, cnt=0;
        while(end<target){
            for(int i=0;i<stations.length;i++){
                //System.out.println(stations[i][0]+" "+end);
                if(stations[i][0]<=end && stations[i][0]>=0 ){
                    pq.add(stations[i]);
                    stations[i][0]=-1;
                }
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