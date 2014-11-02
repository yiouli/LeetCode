/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * @see <a href="https://oj.leetcode.com/problems/3sum/">3 Sum on LeetCode</a>
 */
public class ThreeSum {

	//idx between 0 to num.length-1
	private int skipDuplicate(int[] num, int idx, boolean backward) {
		int n = num.length;
		int next = backward ? idx - 1 : idx + 1;
		while(next > -1 && next < n && num[idx] == num[next]) {
			idx = next;
			next = backward ? next - 1 : next + 1;
		}
		return next;
	}
	
    public List<List<Integer>> threeSum(int[] num) {
    	Arrays.sort(num);
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	int n = num.length;
    	for(int i = 0; i < n-2; i = skipDuplicate(num, i, false)) {
    		int j = i+1, k = n-1;
    		while (k > j) {
    			int sum = num[i] + num[j] + num[k];
    			if (sum == 0) {
    				List<Integer> triple = new ArrayList<Integer>();
    				triple.add(num[i]);
    				triple.add(num[j]);
    				triple.add(num[k]);
    				ret.add(triple);
    				j = skipDuplicate(num, j, false);
    				k = skipDuplicate(num, k, true);
    			}
    			else if (sum > 0) k--;
    			else j++;
    		}
    	}
    	return ret;
    }
}
