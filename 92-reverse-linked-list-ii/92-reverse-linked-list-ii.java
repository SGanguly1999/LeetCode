/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode currentNode,prevNode,nextNode;
        ListNode node1,node2;
        node1 = null;
        node2 = null;
        currentNode = head;
        prevNode = null;
        boolean flag = false;
        int pos = 1;
        while(currentNode!=null) {
            nextNode = currentNode.next;
            if(flag) {
                currentNode.next = prevNode;
            }
            if(pos == left) {
                node1 = prevNode;
                flag = true;
            }
            if(pos == right) {
                flag = false;
                if(node1 == null) {
                    head.next = nextNode;
                    head = currentNode;
                }
                else {
                    node1.next.next = nextNode;
                    node1.next = currentNode;
                }
                
            }
            prevNode = currentNode;
            currentNode = nextNode;
            pos++;
        }
        currentNode = head;
        /*while(currentNode!=null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }*/
        return head;
    }
}