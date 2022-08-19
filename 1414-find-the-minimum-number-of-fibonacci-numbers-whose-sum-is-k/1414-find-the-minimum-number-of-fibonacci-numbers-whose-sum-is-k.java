class Solution {
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) return k;
        int a = 1, b = 1;
        while (b <= k) {
            int c=a+b;
            a=b;
            b=c;
            
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }
}