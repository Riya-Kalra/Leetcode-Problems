class Solution {
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
        return maxArea;
    }
}
//For any bar i the maximum rectangle is of width r - l - 1 where r - is the last coordinate of the bar to the right with height h[r] >= h[i] and l - is the last coordinate of the bar to the left which height h[l] >= h[i]