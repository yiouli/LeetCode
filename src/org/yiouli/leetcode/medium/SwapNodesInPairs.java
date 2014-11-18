/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * 
 * @see <a href="https://oj.leetcode.com/problems/swap-nodes-in-pairs/">Swap Nodes In Pairs on LeetCode</a>
 */
public class SwapNodesInPairs { 
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode swapPairs(ListNode head) {
		ListNode prev = new ListNode(0), first = prev;
		prev.next = head;
		while (head != null && head.next != null) {
			prev.next = head.next;
			head.next = head.next.next;
			prev.next.next = head;
			prev = head;
			head = head.next;
		}
		return first.next;
	}

}
