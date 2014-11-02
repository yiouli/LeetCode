/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [[2],[1],[1,2,2],[2,2],[1,2],[]]
 * 
 * @see <a href="https://oj.leetcode.com/problems/subsets-ii/">Subsets II on LeetCode</a>
 */
public class Subset2 {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) return ret;
		Arrays.sort(num);
		ret.add(new ArrayList<Integer>());
		int j = 0;
		for(int i=0; i<num.length; i++) {
			int n = ret.size();
			if (i!=0 && num[i]!=num[i-1]) j = 0;
			for (; j<n; j++) {
				List<Integer> subset = new ArrayList<Integer>(ret.get(j));
				subset.add(num[i]);
				ret.add(subset);
			}
			j = n;
		}
		return ret;
	}
}
