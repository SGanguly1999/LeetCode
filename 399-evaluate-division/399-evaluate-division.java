class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double result[] = new double[queries.size()];
        int len = 2 * equations.size();
        ArrayList<Integer> arr[] = new ArrayList[len];
        double val[][] = new double[len][len];
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int counter = 0;
        int eq_no = 0;
         
        // Creating the graph;
        
        for(List<String> i:equations) {
            int c = 0;
            int s[] = new int[2];
            for(String m:i){
                if(!map.containsKey(m)) {
                    map.put(m,counter);
                    arr[counter] = new ArrayList<Integer>();
                    counter++;
                }
                s[c++] = map.get(m);
                if(c == 2) {
                    val[s[0]][s[1]] = values[eq_no];
                    val[s[1]][s[0]] = 1/values[eq_no];
                    arr[s[0]].add(s[1]);
                    arr[s[1]].add(s[0]);
                }
            }
            eq_no++;
        }
        
        
        // Finding route to a destination 
        int sou,des,c=0;
        loop1: for(List<String> qu:queries) {
            String v1 = qu.get(0);
            String v2 = qu.get(1);
            result[c] = -1;
            if(map.containsKey(v1) && map.containsKey(v2)) {
                //System.out.println(c);
                sou = map.get(v1);
                des = map.get(v2);
            }
                else {
                    //System.out.println(map.containsKey(v1)+" "+v2+" "+c);
                    c++;
                    continue;
                }
                    
            int visited[] = new int[counter];
            double dist[] = new double[counter];
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(sou);
            visited[sou] = 1;
            dist[sou] = 1;
            if(sou == des) {
                result[c++] = 1;
                continue;
            }
           loop2: while(!queue.isEmpty()) {
                int valo = queue.poll();
                for(int i:arr[valo]) {
                    if(visited[i] == 0) {
                        queue.add(i);
                        dist[i] = dist[valo] * val[valo][i];
                        visited[i]=1;
                        if(i == des) {
                           // System.out.println(i+" "+dist[valo]);
                            result[c++] = dist[i];
                            continue loop1;
                        }
                    }
                }
            }
            c++;
        }
        return result;
    }
}