class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n=t.length;
        Stack<Integer> s= new Stack<>();
        int a[]=new int[n];
        int i=n-1;
        for(int j=n-1;j>=0;j--){
            while(!s.isEmpty() && t[s.peek()]<=t[j] )
                s.pop();
            if(s.isEmpty())
                a[j]=0;
            else
                a[j]=s.peek()-j;
            s.push(j);
        }
        return a;
    }
}