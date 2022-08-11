class Solution {
    int min_sessions = Integer.MAX_VALUE;
    ArrayList<Integer> sessions= new ArrayList<>();
    
    public int minSessions(int[] tasks, int sessionTime) {
        
        bt(0, tasks, sessionTime);
        return min_sessions;
    }
     void bt(int index, int []tasks, int target)
    {
        if(sessions.size() > min_sessions)
            return;
        
        // ending
        if(index == tasks.length){
            min_sessions = Math.min(min_sessions, sessions.size());
            return;
        }
        
        // check if the task[index] can be added to an existing session
        for(int i=0;i<sessions.size();i++){
            if(sessions.get(i) + tasks[index] <= target){
                sessions.set(i,sessions.get(i) +tasks[index]);
                bt(index+1, tasks, target);
                sessions.set(i,sessions.get(i) -tasks[index]);
            }
        }
        
        // add it to a new session
        sessions.add(tasks[index]);
        bt(index+1, tasks, target);
        sessions.remove(sessions.size()-1);
    }
    
}