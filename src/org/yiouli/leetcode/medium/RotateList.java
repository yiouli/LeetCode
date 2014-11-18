/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @see <a href="https://oj.leetcode.com/problems/rotate-list/">Rotate List on LeetCode</a>
 */
public class RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) return head;
		ListNode node = head;
		int count = 1;
		while (node.next != null) {
			count++;
			node = node.next;
		}
		node.next = head;
		for (int i=count-n%count;i>0;i--) node = node.next;
		head = node.next;
		node.next = null;
		return head;
	}
	
	public ListNode rotateRightFirstDraft(ListNode head, int n) {
		if (head == null || n == 0) return head;
		ListNode slow = head, fast = head;
		for (int i=0; i<n; i++) {
			fast = fast.next == null ? head : fast.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}
}
