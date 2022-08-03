class Solution {
    public boolean isRobotBounded(String instructions) {
       if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0;  // initial points of the robot
        String directions = "North"; // initial direction of robot 
        for(int i=0;i<instructions.length();i++){
            char ch=instructions.charAt(i);
            if(ch=='G'){
                if(directions=="North")
                    y++;
                else if (directions=="South")
                    y--;
                else if (directions=="West")
                    x--;
                else
                    x++;
                
            }
            else if(ch=='L'){
                if(directions=="North")
                    directions="West";
                else if (directions=="South")
                    directions="East";
                else if (directions=="West")
                    directions="South";
                else
                    directions="North";
            }
            else if(ch=='R'){
                if(directions=="North")
                    directions="East";
                else if (directions=="South")
                    directions="West";
                else if (directions=="West")
                    directions="North";
                else
                    directions="South";
            }
        }
        if(x==0 && y==0)
            return true;
        if (directions.equals("North"))
            return false;
        return true;
    }
}