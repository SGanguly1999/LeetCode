class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> a = new HashMap<Character,Integer>();
        int p1 = 0,p2 = 0;
        int max  = 0;
        for(p2 = 0; p2 < s.length(); p2++) {
            char c = s.charAt(p2);
            if(a.containsKey(c) && p1 < a.get(c)){
                max = Math.max(max,p2-p1);
                p1 = a.get(c);
            }
                a.put(c,p2+1);
        }
        max = Math.max(max,p2-p1);
        return max;
    }
}