class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> a = new ArrayList<>();
        if(intervals.length==0){
           a.add(newInterval);
           return a.toArray(new int[a.size()][]);
        }
        int i=0;
        while(i<n && (intervals[i][1]<newInterval[0])){
                a.add(intervals[i++]);
        }
        int start=newInterval[0];
        int end=newInterval[1];
        while(i<n && intervals[i][0]<=newInterval[1]){
            start=Math.min(intervals[i][0],start);
            end=Math.max(intervals[i][1],end);
            i++;
        }
        a.add(new int[]{start,end});
        while(i<n){
                a.add(intervals[i++]);
        } 
        return a.toArray(new int[a.size()][]);

    }
}