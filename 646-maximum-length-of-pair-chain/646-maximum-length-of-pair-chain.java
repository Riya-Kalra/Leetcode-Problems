class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr=Integer.MIN_VALUE, chain=0;
        for(int i=0; i<pairs.length; i++){
            if(curr < pairs[i][0]){
                curr = pairs[i][1];
                chain++;
            }
            
        }
        return chain;
    }
}