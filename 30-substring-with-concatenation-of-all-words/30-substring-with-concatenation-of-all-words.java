class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wl,sl;
        wl = words.length;
        sl = s.length();
        int check = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        HashMap<String,Integer> map1 = new HashMap<String,Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < wl; i++){
            String word = words[i];
            map1.put(word,0);
            if(map.containsKey(word))
                map.put(words[i],map.get(words[i])+1);
            else {
                map.put(words[i],1);
                check++;
            }
        }
        
        // Performing sliding window on s
        
        int start = 0;
        int word_len = words[0].length(); 
        int end = word_len * wl;
        int size = end;
       // System.out.println(s.length()-size);
        for(int i = 0 ; i < s.length()-size+1; i++) {
            
            int check1 = 0;
            int st = i;
            HashMap<String,Integer> map2 = new HashMap<String,Integer>();
            for(int j = st+word_len;j<=end;j+=word_len){ // Traversing the window
                
              String m = s.substring(st,j);
             // System.out.println(m+" "+i+" "+st+" "+j);
              st = j;

              if(map1.containsKey(m)) {
                 if(!map2.containsKey(m)) {
                     map2.put(m,0);
                     map1.put(m,0);
                 }
                 int ini = map1.get(m);
                 int now = ini+1;
                 map1.put(m,now);
                  
                 if(ini == map.get(m)) {
                     check1--;
                     break;
                 }
                 else if(now == map.get(m))
                     check1++;
              }
                else
                    break;
            
            }
            if(check1 == check)
                res.add(i);
            end++;
            
        } 
        return res;
    }
}