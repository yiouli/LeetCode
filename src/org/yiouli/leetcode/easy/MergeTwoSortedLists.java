/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

/**
 * Merge two sorted linked lists and return it as a new list. The 
 * new list should be made by splicing together the nodes of the 
 * first two lists.
 * 
 * @see <a href="https://oj.leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists on LeetCode</a>
 */
public class MergeTwoSortedLists {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), prev = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				prev = l1;
				l1 = l1.next;
			}
			else {
				prev.next = l2;
				prev = l2;
				l2 = l2.next;
			}
		}
		if (l1 != null) prev.next = l1;
		else prev.next = l2;
		return head.next;
	}
}
