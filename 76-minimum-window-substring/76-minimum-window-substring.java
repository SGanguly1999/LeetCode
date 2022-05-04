class Solution {
    public String minWindow(String s, String t) {
     int p_rear,p_front,min_size;
        p_rear = p_front = 0;
        int p_prev = -1;
        min_size = s.length();
        int  min_point = -1;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> winmap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> setcheck = new HashMap<Character,Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int dest = 0;
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else {
                map.put(c,1);
                dest++;
            }
            setcheck.put(c,0);
        }
        boolean r_flag = true;
        int sum = 0;
        int size = 0;
        for(p_front = 0; p_front < s.length();){
            if(p_prev<p_front) {
                p_prev = p_front;
            char c = s.charAt(p_front);
            if(map.containsKey(c) && r_flag) {  // Setting the rear pointer
                p_rear = p_front;
                r_flag = false;
            }
            size = p_front - p_rear + 1;
            if(map.containsKey(c)) { // Entry into the sliding window map
                if(winmap.containsKey(c))
                    winmap.put(c,winmap.get(c)+1);
                else
                    winmap.put(c,1);
                if(p_front != p_rear)
                queue.add(p_front);
                
                int map_val = map.get(c);
                int winmap_val = winmap.get(c);
                //System.out.println(sum+" "+dest+" "+p_rear+" "+p_front+" "+map_val+" "+winmap_val);
                if(setcheck.get(c) == 0 && map_val == winmap_val) {
                    sum+=1;
                    setcheck.put(c,1);
                }     
            }
            }
           
            if(sum == dest) {
                char d = s.charAt(p_rear);
                winmap.put(d,winmap.get(d)-1);
                 
                if(winmap.get(d) < map.get(d) && setcheck.get(d) == 1) {
                    sum-=1;
                    setcheck.put(d,0);
                }
                if(winmap.get(d) == 0)
                    winmap.remove(d);
                size = p_front - p_rear+1;
                if(min_size >= size) {
                    min_size = size ;
                    min_point = p_rear;
                }
                if(p_rear == p_front) {
                    p_front++;
                    r_flag = true;
                }
                else {
                int p_next = queue.poll();
                p_rear = p_next;
                }
            
            }
            else {
                if(p_front < s.length()-1) {
                  p_front++;
                }
                else
                   break; 
            }
            
        }
        String res = "";
        System.out.println(min_size);
        for(int i = min_point;i<min_point+min_size && min_point!=-1;i++)
            res+=s.charAt(i);
        return res;
    }
    
}