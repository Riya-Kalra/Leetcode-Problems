class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int leftmax[]=new int[n];
        int rightmax[]=new int[n];
        Stack <Integer> stk= new Stack<>();
        leftmax[0]=0;
        stk.push(0);
        for(int i=1;i<n;i++){
             while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                 stk.pop();
             }
            if(stk.isEmpty())
                leftmax[i]=0;
            else
                leftmax[i]= stk.peek()+1;
            stk.push(i);
        }
        stk.clear();
        stk.push(n-1);
        rightmax[n-1]=n-1;
        for(int i=n-2;i>=0;i--){
             while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                 stk.pop();
             }
            if(stk.isEmpty())
                rightmax[i]=n-1;
            else
                rightmax[i]= stk.peek()-1;
            stk.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++)
            max=Math.max(max,(rightmax[i]-leftmax[i]+1)*heights[i]);
        return max;
    }
}
// for any bar to be included it