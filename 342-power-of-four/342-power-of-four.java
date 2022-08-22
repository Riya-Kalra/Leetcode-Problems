class Solution {
    public boolean isPowerOfFour(int n) {
        int x=1, ans=1;
        if(n==1) return true;
        for(int i=0;i<32;i++){
            ans=ans<<2;
            if(ans==n)
                return true;
            else if(ans>n)
                return false;
        }
        return false;
    }
}