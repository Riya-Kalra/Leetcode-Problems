class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length-1; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            for(int j = i+1; j < points.length; j++){
                    if((points[j][0]== points[i][0]) && (points[j][1] == points[i][1])){
                        continue;
                    }
                    else if(points[j][0] == points[i][0]){
                        samex++;
                    }
                    else{
                    double k = 0;
                        
                    if(points[j][1]!=points[i][1])
                        k=(double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);
                        
                    if(hm.containsKey(k))
                        hm.put(k,hm.get(k) + 1);
                    else
                        hm.put(k, 2);
                    
                    result = Math.max(result, hm.get(k));
                        //System.out.println("Map "+k+" "+hm.get(k)+" "+result);
                    }
            }
            //System.out.println(samex+" "+result);
            result = Math.max(result, samex);
        }
        return result;
    }
}