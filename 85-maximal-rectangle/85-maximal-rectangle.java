class Solution {
    public int maximalRectangle(char[][] matrix) {
        int dp[]= new int[matrix[0].length];
        int max=0,i=0;
        while(i<matrix.length){
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]=='1')
                dp[j]+=matrix[i][j]-'0';
                else
                dp[j]=0;
           // System.out.println(Arrays.toString(dp));
            max=Math.max(max,largestRectangleArea(dp));
            i++;
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length, maxArea = 0;
        stack.push(-1);
        for(int i = 0; i < n; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int h = heights[stack.pop()];
            int w = n - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
       // System.out.println(maxArea);
        return maxArea;
    }
}