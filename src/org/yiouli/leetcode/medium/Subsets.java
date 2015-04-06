/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 * 
 * @see <a href="https://oj.leetcode.com/problems/subsets/">Subsets on LeetCode</a>
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        long total = (long)Math.pow(2, S.length), mask = 0;
        while (mask++ < total) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int i=0;i<S.length;i++)
                if ((mask & (1<<i)) != 0) subset.add(S[i]);
            results.add(subset);
        }
        return results;
    }
}
