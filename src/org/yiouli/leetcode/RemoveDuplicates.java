/**
 * @author Yiou Li
 */
package org.yiouli.leetcode;
/**
 * Given a sorted array, remove the duplicates in place such that 
 * each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this 
 * in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove duplicates on LeetCode</a>
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] != A[j]) A[++j] = A[i];
        }
        return j+1;
    }
}
