class Solution {
    public boolean isPossible(int[] nums) {
        HashMap <Integer,Integer> map =new HashMap<>();// store count of each ele
        HashMap <Integer,Integer> end =new HashMap<>();// no of subsequences ending with this ele
        
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        for (int n :nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)-1);
                if(map.get(n)<=0) map.remove(n);
                
                if(end.containsKey(n-1) ){
                    end.put(n,end.getOrDefault(n,0)+1);
                    end.put(n-1,end.get(n-1)-1);
                    if(end.get(n-1)<=0) end.remove(n-1);
                    
                }
                else if (map.containsKey(n+1) && map.containsKey(n+2)){
                    
                    end.put(n+2,end.getOrDefault(n+2,0)+1);
                    map.put(n+1,map.get(n+1)-1);
                    map.put(n+2,map.get(n+2)-1);
                    if(map.get(n+1)<=0) map.remove(n+1);
                    if(map.get(n+2)<=0) map.remove(n+2);
                    
                }
                else
                    return false;
                
            }
            //System.out.println(map);
            //System.out.println(" end "+ end);
        }
        return true;
    }
}