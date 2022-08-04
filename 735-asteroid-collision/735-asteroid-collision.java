class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> s= new Stack<>();
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.peek() < 0)
                s.add(a[i]);
            else if (s.peek() <= -a[i])
                if (s.pop() < -a[i]) i--;
        }
        int[] ans = new int[s.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = s.pop();
        }
        return ans;
    }
}