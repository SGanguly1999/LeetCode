class Source implements Comparator<Source> {
    int no;
    int dist; 
    int colour;
    ArrayList<Dest> list;
    public Source() {
        colour = 0;
        dist = Integer.MAX_VALUE;
        list = new ArrayList<Dest>();
    }  
    public int compare(Source o1,Source o2) {
        //System.out.println("Dist comparison "+o1.no+" "+o2.no);
        if(o1.dist > o2.dist)
            return 1;
        else if(o1.dist < o2.dist)
            return -1;
        else
            return 0;
    }
}
class Dest {
    int v;
    int weight;
    public Dest(int v,int wei) {
        this.v = v;
        weight = wei;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    Source graph[]= new  Source[n+1];
        for(int i =1;i<n+1;i++) {
            graph[i] = new Source();
            graph[i].no = i;
        }
        for(int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int weight = times[i][2];
            graph[u].list.add(new Dest(v,weight));  
        }
        int max = 0;
        int count = 0;
        PriorityQueue<Source> queue= new PriorityQueue<Source>(new Source());
        graph[k].dist = 0;
        queue.add(graph[k]);
        graph[k].colour = 1;
        count++;
        while(!queue.isEmpty()) {
            Source node = queue.remove();
            if(max < node.dist)
                max = node.dist;
            for(Dest dest: node.list) {
                 int n1 = dest.v;
                 int wei = dest.weight;
                //System.out.println(node.no+"---->"+n1+" "+graph[n1].colour);
                if(graph[n1].colour == 2)
                    continue;
                 else if(graph[n1].colour == 0) {
                     count++;
                     graph[n1].colour = 1;
                 }
                 int prev = graph[n1].dist;
                 graph[n1].dist = Math.min(graph[n1].dist,node.dist + wei);
                 if(prev > graph[n1].dist)
                     queue.add(graph[n1]);
                 System.out.println(k+"---dist-->"+n1+" "+graph[n1].dist);
                 graph[n1].colour = 1;
            }
            view(queue);
            System.out.println("End of "+node.no);
            node.colour = 2;
        }
        if(count == n)
          return max;
        else
            return -1;
    }
    public void view(PriorityQueue<Source> obj) {
        for(Source m:obj) {
            System.out.println(m.no+" "+m.dist);
        }
    }
}
