/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 * 
 * @see <a href="https://oj.leetcode.com/problems/lru-cache/">LRU Cache on LeetCode</a>
 */
public class LRUCache {
	public class ListNode {
		int key;
		int val;
		ListNode prev;
		ListNode next;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private ListNode sentinel;
	private HashMap<Integer, ListNode> map;
	private int capacity;

	//capacity == 0 will cause problem
	public LRUCache(int capacity) {
		sentinel = new ListNode(0, 0);
		sentinel.prev=sentinel;
		sentinel.next=sentinel;
		map = new HashMap<Integer, ListNode>();
		this.capacity = capacity;
	}

	private ListNode removeFromQueue(int key) {
		ListNode node = null;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		return node;
	}

	private void appendToQueue(ListNode node) {
		sentinel.prev.next = node;
		node.prev = sentinel.prev;
		node.next = sentinel;
		sentinel.prev = node;
	}

	public int get(int key) {
		ListNode node = removeFromQueue(key);
		if (node == null) return -1;
		appendToQueue(node);
		return node.val;
	}

	public void set(int key, int value) {
		ListNode node = removeFromQueue(key);
		if (node == null) {
			if (map.size() == capacity) {
				//assuming capacity not 0, this shouldn't be sentinel
				node = sentinel.next;
				sentinel.next = node.next;
				node.next.prev = sentinel;
				map.remove(node.key);
			}
			node = new ListNode(key, value);
			map.put(key, node);
		}
		else node.val = value;
		appendToQueue(node);
	}
}
