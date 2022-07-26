class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int job[][] = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            job[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(job, (a, b) ->a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap();//store max profit when we take ith job into considerstion
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            Integer prevJob = map.floorKey(job[i][0]);//return the greatest key less than or equal to given key from the parameter so return the profit by the job before starting point
            int prevSum = prevJob == null ? 0 : map.get(prevJob);
            max = Math.max(max, prevSum + job[i][2]);
            map.put(job[i][1], max);
        }
        
        return max;
    }
}