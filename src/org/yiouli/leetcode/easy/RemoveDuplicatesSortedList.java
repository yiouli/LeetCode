/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each 
 * element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List on LeetCode</a>
 */
public class RemoveDuplicatesSortedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode current = head;
		while (current.next != null) {
			if (current.next.val == current.val) current.next = current.next.next;
			else current = current.next;
		}
		return head;
	}
}
