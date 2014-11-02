/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is 
 * closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @see <a href="https://oj.leetcode.com/problems/3sum-closest/">3Sum Closest on LeetCode</a>
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		int n = num.length;
		Arrays.sort(num);
		int closestDif = Integer.MAX_VALUE;
		for(int i=0;i<n-2;i++){
			int j=i+1, k=n-1, remain=target-num[i];
			while (k > j) {
				int dif = num[j]+num[k]-remain;
				if (dif == 0) return target;
				if (dif > 0) k--;
				else j++;
				if (Math.abs(dif) < Math.abs(closestDif)) closestDif = dif;
			}
		}
		return target + closestDif;
	}
}
