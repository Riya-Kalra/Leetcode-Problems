class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
      int t=(minutesToTest/minutesToDie)+1;
        int T=t;
        int c=1;
        if(buckets==1)return 0;
        while(t<buckets){
           t*=T;
            c++;
        }
        
        return c;
    }
}
