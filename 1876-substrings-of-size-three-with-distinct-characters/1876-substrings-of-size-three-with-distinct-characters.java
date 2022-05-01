class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> check = new HashMap<Character,Integer>();
        int p1 = 0,p2 = 0;
        int size = 3;
        int count  = 0;
        int sum = 0;
        for(p2 = 0;p2<s.length();p2++) {
            char c = s.charAt(p2);
            if(map.containsKey(c)) {
                if(check.get(c) == 1) {
                    sum-=1;
                    check.put(c,0);
                }
                map.put(c,map.get(c)+1);
            }
             else {
               map.put(c,1);
               check.put(c,1);
                 sum+=1;
             }
            //System.out.println(size+" "+c+" "+s.charAt(p1)+" "+p1+" "+p2+" "+sum);
            if(p2 - p1 + 1 == size) {
                if(sum == 3)
                    count++;
                char p = s.charAt(p1);
                if(map.get(p) == 1) {
                    map.remove(p);
                    check.remove(p);
                    sum+=-1;
            }
                else {
                    map.put(p,map.get(p)-1);
                    if(map.get(p) == 1) {
                        check.put(p,1);
                        sum+=1;
                    }
                }
                p1++;
        }
}
        return count;
               }
               }