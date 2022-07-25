class Solution {
    HashMap<String,Integer> map =new HashMap<>();
    public int uniquePaths(int m, int n) {
        if(n == 0 || m == 0){
            return 0;      
        }
        if(n == 1 && m == 1){
            return 1;      
        }
        String cell = new String(m + "," + n);
        if(map.containsKey(cell)) 
            return map.get(cell);
        int down = uniquePaths(m-1,n);
        int right = uniquePaths(m,n-1);
        map.put(cell,right+down);
        return right+down;
    }
}