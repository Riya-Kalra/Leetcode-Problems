class Solution {
    HashMap <String,String> parent= new HashMap<>();
    
     int count;
    public int removeStones(int[][] stones) {
        int n=stones.length;
        count=n;
        System.out.println(count);
        for(int i=0;i<n;i++){
            String s = stones[i][0] + " " + stones[i][1];
            parent.put(s,s);
          
            
        }
       for (int[] s1 : stones) {
            String ss1 = s1[0] + " " + s1[1];
            for (int[] s2 : stones) {
                if (s1[0] == s2[0] &&  s1[1] == s2[1])
                    continue;
                else if (s1[0] == s2[0] || s1[1] == s2[1]) { // in the same column or row
                    String ss2 = s2[0] + " " + s2[1];
                    union(ss1, ss2);
                }
            }
       }
        return n-count; 
    }
    public String findParent(String node){
        if(parent.get(node).equals(node))
            return node;
       return findParent(parent.get(node));
    }
    public void union(String u,String v){
        String rootu=findParent(u);
        String rootv=findParent(v);
       // System.out.println(u+" "+v+" "+count);
        if(rootu.equals(rootv))
            return ;
       
        parent.put(rootu,rootv);
               
        count--;
    }
}