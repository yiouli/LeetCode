/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] 
 * 
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/">Combination Sum II on LeetCode</a>
 */
public class CombinationSum2 {
    private void findRemaining(int[] num, int start, int target, List<Integer> subset, List<List<Integer>> results) {
        if (target == 0) results.add(new ArrayList<Integer>(subset));
        else {
            while(start<num.length) {
                if (target < num[start]) return;
                int current = num[start];
                subset.add(current);
                findRemaining(num, start+1, target-current, subset, results);
                subset.remove(subset.size()-1);
                while (++start < num.length && num[start] == current);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        findRemaining(num, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }
}
