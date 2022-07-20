class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int a[] = new int[words.length];
        String words2[] = new String[words.length];
        int count = 0,point = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int j = 0; j < words.length; j++) {
            if(map.containsKey(words[j]))
                map.put(words[j],map.get(words[j])+1);
            else {
                map.put(words[j],1);
                words2[point++] = words[j];
            }
        }
        
        for(int j=0;j<point;j++) {
            int match=0;
            for(int i = 0; i < s.length();i++) {
                if(match < words2[j].length() && s.charAt(i) == words2[j].charAt(match))
                    match++;
                if(match == words2[j].length())
                    break;
            }
            if(match == words2[j].length())
                count+=map.get(words2[j]);
        }
        return count;
    }
}