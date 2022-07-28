class Solution {
    public int numBusesToDestination(int[][] routes, int s, int t) {
       HashSet<Integer> visited = new HashSet<>();//Contains the bus no. that are being traversed
       Queue<Integer> q = new LinkedList<>();//Storing the stops 
       HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        if (s==t) return 0;
        int no_ofBuses=0;
        for(int i=0;i<routes.length;i++){
            for(int j = 0; j < routes[i].length; j++){
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);                
            }      
        }//stops are the key and bus no. reaching there are values in the arraylist
        q.offer(s); 
       while (!q.isEmpty()) {
           int len = q.size();
           no_ofBuses++;
           for (int i = 0; i < len; i++) {
               int cur = q.poll();
               ArrayList<Integer> buses = map.get(cur);
               for(Integer bus:buses){
                   if (visited.contains(bus)) 
                       continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == t)// if bus sees the target then return the no. of buses we need to switch 
                            return no_ofBuses;
                        q.offer(routes[bus][j]);  
                   }
               }
           }  
       }
        return -1;
    }
}