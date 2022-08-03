class Solution {
    public int[][] merge(int[][] intervals) {
      int i=1,n=intervals.length;
        ArrayList<int[]> a = new ArrayList<>();
        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        int start=intervals[0][0];
        int end= intervals[0][1];
        while(i<n){
          if(intervals[i][0]<=end){
              end=Math.max(end,intervals[i][1]);
          }
          else{
              a.add(new int[]{start,end});
              start=intervals[i][0];
              end=intervals[i][1];
          }
            i++;
        }
         a.add(new int[]{start,end});
        return a.toArray(new int[a.size()][]);
    }
}