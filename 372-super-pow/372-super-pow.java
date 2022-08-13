class Solution {
    int mod=1337;
    public int superPow(int a, int[] b) {
         return myPow(a, b, -1);
    }
    public int myPow( int x, int b[],int index) {
         if(index == b.length - 1){
            return 1;
        }
        boolean even = b[b.length - 1] % 2 == 0;
        int newIndex = divide(b, index);
        long half=myPow(x,b,newIndex);
         if(even){
            return (int)((half * half) % mod);
        }else{
            return (int)((x * half * half) % mod);
        }
    }
        public int divide(int b[], int index){
        int newIndex = index, rem = 0;
        for(int i = index + 1; i < b.length; i++){
            int val = rem * 10 + b[i];
            rem = val % 2;
            b[i] = val/2;
        }
        while((newIndex + 1) < b.length && b[newIndex + 1] == 0){
            newIndex++;
        }
        return newIndex;
    }

   
}