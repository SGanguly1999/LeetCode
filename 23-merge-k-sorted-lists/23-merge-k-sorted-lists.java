import java.util.*;
/*class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean headFlag = true;
        int  no_list = lists.length;
        ListNode head = null,currentNode = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new NodeComparator());
        for(int i=0;i<no_list;i++) {
            if(lists[i] != null)
            queue.add(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if(headFlag) {
                head = node;
                headFlag = false;
                currentNode = head;
            }
            else {
                currentNode.next = node;
                currentNode = node;
            }
            if(node.next!=null)
            queue.add(node.next); 
        }
        return head;
    }
}
class NodeComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}
