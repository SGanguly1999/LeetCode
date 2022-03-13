class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1)
            return 0;
        int end = (1<<n)-1;
        boolean[][] seen = new boolean[n][end];
        MyList q = new MyList();
        for(int i = 0; i < n; i++){
            q.add((i<<n)|(1<<i));
            seen[i][1<<i] = true;
        }
        int count = 1;
        for(;;){
            for(int size = q.size(); size>0; size--){
                int curr = q.poll();
                for(int nei : graph[curr>>n]){
                    int next = (curr&end)|(1<<nei);
                    if(next == end)
                        return count;
                    if(!seen[nei][next]){
                        seen[nei][next] = true;
                        q.add((nei<<n)|next);
                    }
                }
            }
            count++;
        }
    }
}
class MyList{
    MyNode head;
    MyNode tail;
    int _size = 0;
    void add(int val){
        _size++;
        if(head == null){
            head = new MyNode(val);
            tail = head;
        }else{
            tail.next = new MyNode(val);
            tail = tail.next;
        }
    }
    int poll(){
        int temp = head.val;
        head = head.next;
        _size--;
        return temp;
    }
    int size(){
        return this._size;
    }
    class MyNode{
        MyNode next;
        int val;
        MyNode(int val){
            this.val = val;
        }
    }
}