class Solution {
    HashMap <String,String> parent= new HashMap<>();
     HashMap <String,Integer> size= new HashMap<>();
     int count;
    public int removeStones(int[][] stones) {
        int n=stones.length;
        count=n;
        System.out.println(count);
        for(int i=0;i<n;i++){
            String s = stones[i][0] + " " + stones[i][1];
            parent.put(s,s);
            size.put(s,1);
            
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
        String x=findParent(parent.get(node));
        parent.put(node, x );
        return x;
       // return findParent(parent.get(node));
    }
    public void union(String u,String v){
        String rootu=findParent(u);
        String rootv=findParent(v);
       // System.out.println(u+" "+v+" "+count);
        if(rootu.equals(rootv))
            return ;
        if(size.get(rootu)> size.get(rootv)) {
                parent.put(rootv,rootu);
                size.put(rootu,size.get(rootu) +size.get(rootv));
        } 
        else {
                parent.put(rootu,rootv);
                size.put(rootv,size.get(rootv) +size.get(rootu));
        }
        count--;
    }
}