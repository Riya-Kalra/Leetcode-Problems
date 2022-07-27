class CheckIn{
    int time;
    String station;
    CheckIn(int time, String station){
        this.time = time;
        this.station = station;
    }
}
class UndergroundSystem {
    Map<String, int[]> avgTime;
    Map<Integer, CheckIn> customerCheckIn;
    public UndergroundSystem() {
        avgTime=new HashMap<>();
        customerCheckIn=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customerCheckIn.put(id,new CheckIn(t,stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = this.customerCheckIn.get(id);
        String route = checkIn.station + "#" + stationName;
        int time[] = this.avgTime.getOrDefault(route, new int[2]);
        time[0]+= t-checkIn.time;//sum
        time[1]+=1;//count
        //therefore avg will be sum/count
        if(!avgTime.containsKey(route)){
            avgTime.put(route, time);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
         String route = startStation + "#" + endStation;
        int temp[] = avgTime.get(route);
        double time = (double)temp[0]/temp[1];
        return time;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */