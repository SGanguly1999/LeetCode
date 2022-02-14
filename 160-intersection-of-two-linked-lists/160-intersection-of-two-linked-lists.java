/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
		return null;
	}

	ListNode current = headA;

	int lenA = 0;
	while(current!=null){
		lenA++;
		current = current.next;
	}
	
	int lenB = 0;
	current = headB;
	while(current!=null){
		lenB++;
		current = current.next;
	}

	ListNode currentA = headA;
	ListNode currentB = headB;

	int offset = lenA-lenB;
	while(offset>0){
		currentA = currentA.next;
		offset--;
	}

	while(offset<0){
		currentB = currentB.next;
		offset++;
	}

	while(currentA!=null && currentB!=null){
		if(currentA == currentB){
			return currentA;
		}
		currentA = currentA.next;
		currentB = currentB.next;
	}

	return null;
    }
}