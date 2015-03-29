/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in k-group on LeetCode</a>
 */
public class ReverseKGroup {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode current = head;
		int count = 0;
		while (current != null && count < k) {
			current = current.next;
			count++;
		}
		if (count == k) {
			current = reverseKGroup(current, k);
			while (count-- > 0) {
				ListNode tmp = current;
				current = head;
				head = head.next;
				current.next = tmp;
			}
			head = current;
		}
		return head;
	}
}
