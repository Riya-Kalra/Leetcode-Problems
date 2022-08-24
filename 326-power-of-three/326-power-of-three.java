class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1) return false;
        long x=1;
        while(x<=n){
            if(x==n) return true;
            x=x*3;
        }
        return false;
    }
}