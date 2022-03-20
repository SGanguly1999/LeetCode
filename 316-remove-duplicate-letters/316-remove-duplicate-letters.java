class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int count = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) 
                map.put(c,map.get(c)+1);
            else {
                map.put(c,1);
                count++;
            }
        }
        char min = 'z';
        int currInd = 0;
        String final_string ="";
        int j;
       for(int i=0;i<count;i++) {
           j = currInd;
           HashMap<Character,Integer> checkMap = new HashMap<Character, Integer>();
           min ='z';
           while(j<s.length()) {
               char c = s.charAt(j);
               if(!map.containsKey(c)) {
                   j++;
                   continue;
               }
            if(checkMap.containsKey(c)) 
            checkMap.put(c,checkMap.get(c)+1);
            else {
                checkMap.put(c,1);
            }  
               if(min > c) {
                   for(int m = currInd; m<j;m++) {
                       if(map.containsKey(s.charAt(m)))
                        map.put(s.charAt(m),map.get(s.charAt(m))-1);
                        if(checkMap.containsKey(s.charAt(m)))
                       checkMap.put(s.charAt(m),checkMap.get(s.charAt(m))-1);
                   }
                   System.out.println(currInd +" "+j+" "+min+" "+c);
                   min = c;
                   currInd = j;
               }
             if(checkMap.get(c) >= map.get(c))
                 break;
             j++;
           }
        final_string +=min;
         map.remove(min);
           
       }
        return final_string;
    }
}