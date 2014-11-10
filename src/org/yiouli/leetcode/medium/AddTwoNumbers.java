/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * You are given two linked lists representing two non-negative numbers. The digits 
 * are stored in reverse order and each of their nodes contain a single digit. Add 
 * the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @see <a href="https://oj.leetcode.com/problems/add-two-numbers/">Add Two Numbers on LeetCode</a>
 */
public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		int carry = 0;
		ListNode head = new ListNode(0), prev = head;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			prev.next = new ListNode(sum % 10);
			prev = prev.next;
		}
		if (carry != 0) prev.next = new ListNode(carry);
		return head.next;
	}
}
