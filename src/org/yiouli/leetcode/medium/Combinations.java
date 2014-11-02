/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * 
 * @see <a href="https://oj.leetcode.com/problems/combinations/>Combinations on LeetCode</a>
 */
public class Combinations {
	private void combine(List<List<Integer>> result, LinkedList<Integer> prefix, int n, int k) {
		if (k == 0) result.add(new ArrayList<Integer>(prefix));
		else {
			for(int i = n; i >= k; i--) {
				prefix.addFirst(i);
				combine(result, prefix, i-1, k-1);
				prefix.removeFirst();
			}
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (n < 0 || k < 0) return ret;
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		combine(ret, prefix, n, k);
		return ret;
	}

	private boolean increase(ArrayList<Integer> com, int n, int k) {
		int i = k-1;
		while (i >= 0 && com.get(i) == n+i-k+1) i--;
		if (i < 0) return false;
		com.set(i, com.get(i)+1);
		for (i = i+1; i < k; i++) {
			com.set(i, com.get(i-1)+1);
		}
		return true;
	}
	
	public List<List<Integer>> combineIterative(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (n <0 || k < 0 || n < k) return ret;
		if (k == 0) {
			ret.add(new ArrayList<Integer>());
			return ret;
		}
		ArrayList<Integer> com = new ArrayList<Integer>(k);
		for (int i = 0; i < k; i++) {
			com.add(i, i + 1);
		}
		ret.add(new ArrayList<Integer>(com));
		while (increase(com, n, k)) { 
			ret.add(new ArrayList<Integer>(com));
		}
		return ret;
	}
}
