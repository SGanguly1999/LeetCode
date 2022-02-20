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
    static ListNode currHead;
    static ListNode currEnd,currPrevEnd;
    static int countNodes;
    public ListNode reverseKGroup(ListNode head, int k) {
       countNodes = 0;
        ListNode newHead = null;
       currHead =currEnd = null;
       reverseKelem(head,k);
       newHead = currHead;
       while(currEnd.next!=null) {
       reverseKelem(currEnd.next, k);
       }
       if(countNodes%k!=0) {
           currEnd = currPrevEnd;
           reverseKelem(currHead, countNodes%k);
       }
        return newHead;
    }
    public void reverseKelem(ListNode head,int k) {
        int count = 0;
        ListNode currNode,currPrev;
        currNode = currPrev = null;
        currNode = head;
        currPrev = currNode;
        currNode = head.next;
        count++;
         if(currNode == null) {
             currHead = currEnd = head;
            return;
         }
        while(count != k && currNode != null) {
            count++;
            ListNode currNext = currNode.next;
            currNode.next = currPrev;
            currPrev = currNode;
            currNode = currNext;
        }
        currHead = currPrev;
        if(currEnd!=null)
        currEnd.next = currHead;
        currPrevEnd = currEnd;
        currEnd = head;
        currEnd.next = currNode;
        countNodes+=count;
        //System.out.println(currHead.val +" "+currEnd.val);
    }
}