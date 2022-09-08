class Solution {
    public List<String> generateParenthesis(int n) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        ArrayList<String> list[] = new ArrayList[n];
        list[0] = new ArrayList<String>();
        list[0].add("()");
        for(int i = 2;i<=n;i++) {
            list[i-1] = new ArrayList<String>();
            for( String j : list[i-2]) {
                String val1 = "()"+j;
                if(!map.containsKey(val1)) {
                    list[i-1].add(val1);
                    map.put(val1,1);
                }
                
                for(int k=0;k<j.length();k++) {
                    String sub1 ="(" +j.substring(0,k+1);
                    String sub2 =")"+j.substring(k+1,j.length());
                    val1 = sub1+sub2;
                    if(!map.containsKey(val1)) {
                    list[i-1].add(val1);
                    map.put(val1,1);
                }  
                }
            }
        }
        return list[n-1];
    }
}