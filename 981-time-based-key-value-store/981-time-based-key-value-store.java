class TimeMap {
    HashMap<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map =new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            TreeMap <Integer,String> t=new TreeMap <Integer,String>();
            map.put(key, t);
        }
        TreeMap <Integer,String> t= map.getOrDefault(key, new TreeMap <Integer,String>());
        t.put(timestamp,value);
        
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
           TreeMap <Integer,String> t=map.get(key);
            if(t.floorKey(timestamp)!=null)
                return t.get(t.floorKey(timestamp));
            else
                return ("");
        }
        return ("");
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//foo->bar 1
//fo0->