/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @see <a href="https://oj.leetcode.com/problems/jump-game/">Jump Game on LeetCode</a>
 */
public class JumpGame {
	public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        int dist = A[0];
        for (int i=1;i<=dist;i++) {
            if (dist >= A.length-1) break;
            dist = Math.max(dist, i+A[i]);
        }
        return dist >= A.length-1;
    }
}
