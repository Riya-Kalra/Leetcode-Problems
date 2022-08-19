class Solution {
    public int longestSubstring(String s, int k) {
     return solve(s,0,s.length(),k);
    }
    int solve(String s, int start, int end, int k) {
        if (end < k) return 0;
        int[] count = new int[26];
        // update the count with the count of each character
        for (int i = start; i < end; i++)
            count[s.charAt(i) - 'a']++;
        for (int mid = start; mid < end; mid++) {
            if (count[s.charAt(mid) - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < end && count[s.charAt(midNext) - 'a'] < k) 
                midNext++;
            return Math.max(solve(s, start, mid, k),
                solve(s, midNext, end, k));
        }
        return (end - start);
    }
}