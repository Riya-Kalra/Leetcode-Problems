class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] inf) {
        int i;
         List<Integer>[] subordinates = new List[n];
        for (i = 0; i < n; ++i)
            subordinates[i] = new ArrayList<>();
        for (i = 0; i < n; ++i)
            if (manager[i] >= 0)
                subordinates[manager[i]].add(i);
        Queue <int[]> q=new LinkedList<>();
        q.offer(new int[]{headID, 0});//store id and inform time
        int ans = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int u = top[0], w = top[1];
            ans = Math.max(w, ans);
            for (int v : subordinates[u]) 
                q.offer(new int[]{v, w + inf[u]});
        }
        return ans;
    }
}