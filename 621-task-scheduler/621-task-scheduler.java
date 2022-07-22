class Solution {
    public int leastInterval(char[] tasks, int n) {
     int[] count = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            count[task - 'A']++;
            if(max == count[task - 'A']) {
                maxCount++;
            }
            else if(max < count[task - 'A']) {
                max = count[task - 'A'];
                maxCount = 1;
            }
        }

        
        return Math.max(tasks.length, (max-1)*(n+1)+maxCount);
    }
}//every max character will having a gap of n which might be filled by remaining character