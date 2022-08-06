class AuthenticationManager {
   private int timeToLive;
    private Map<String, Integer> map = new LinkedHashMap<String, Integer>(); 

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        clean(currentTime);
        map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
       clean(currentTime);//cleaning everytime to keep the order correct
        
        if(map.containsKey(tokenId) ) {
            map.remove(tokenId);//To rectify the order we are removing it and then replacing it
            map.put(tokenId, currentTime + timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        clean(currentTime);
        //System.out.println(map.toString());
        return map.size();
    }
    
    private void clean(int currentTime) {
        for(Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            if(map.get(key) <= currentTime) {
                it.remove();
            }else{
                break;
            }
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */