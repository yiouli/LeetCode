package org.yiouli.leetcode.medium;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">Remove Duplicates From Sorted Array II on LeetCode</a>
 */
public class RemoveDuplicates2 {
	public int removeDuplicates(int[] A) {
		//here k = 2, same algo applies for any k
		if (A.length <= 2) return A.length;
		int lastIdx = 1;
        for (int i=2;i<A.length;i++) {
            if (A[i] != A[lastIdx-1]) A[++lastIdx] = A[i];
        }
        return lastIdx+1;
    }
}
