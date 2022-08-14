class Solution {
    public int minTaps(int n, int[] range) {
      int area[][]= new int [n+1][2];
        for(int i=0;i<=n;i++){
            area[i][0]= Math.max(0,i-range[i]);
            area[i][1]= Math.min(n,i+range[i]);
        }
        Arrays.sort(area,(a,b)->(a[0]-b[0]));
        
        
        
        int count = 0, start_time = 0, end_time = 0, i = 0;
        
        while (end_time < n) {
            for (; i <= n && area[i][0] <= start_time; i++) {
                end_time = Math.max(end_time, area[i][1]);
            }
            if (start_time == end_time) return -1;
            start_time = end_time;
            count++;
        }
        return count;
    }
}