class Solution {
    public int mirrorReflection(int p, int q) {
        int m=1,n=1;
        while(m*p!=n*q)
        {
           n++;
           m = n * q / p;
        }
        if(n%2==0) return 2;
        else if(m%2==1) return 1;
        else return 0;
    }
}
/*This problem can be transformed into finding m * p = n * q. Here,
m = the number of room extension + 1.
n = the number of light reflection + 1.

If the number of light reflection is odd (which means n is even), it means the corner is on the left-hand side. The possible corner is 2.
Otherwise, the corner is on the right-hand side. The possible corners are 0 and 1.
Given the corner is on the right-hand side.
If the number of room extension is even (which means m is odd), it means the corner is 1. Otherwise, the corner is 0.*/