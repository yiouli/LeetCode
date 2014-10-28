/**
 * @author Yiou Li
 */
package org.yiouli.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * @see <a href="https://oj.leetcode.com/problems/linked-list-cycle/">Linked List Cycle on LeetCode</a>
 */
public class LinkedListCycle {
	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	//return null if no cycle, or the node when fast and slow pointer met.
	private ListNode FindCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return fast;
        }
        return null;
	}
	
	public boolean hasCycle(ListNode head) {
        return FindCycle(head) != null;
    }
	
	public ListNode FindCycleStart(ListNode head) {
		ListNode met = FindCycle(head);
		if (met == null) return null;
		ListNode restart = head;
		while (restart != met) {
			restart = restart.next;
			met = met.next;
		}
		return restart;
	}
}
