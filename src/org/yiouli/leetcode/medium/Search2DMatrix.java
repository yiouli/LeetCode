/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * @see <a href="https://oj.leetcode.com/problems/search-a-2d-matrix/">Search 2D Matrix on LeetCode</a>
 */
public class Search2DMatrix {
	private int compare(int[][] matrix, long idx, int target) {
		int n = matrix[0].length;
		int row = (int)(idx/n), col = (int)(idx%n);
		return matrix[row][col]-target;
	}

	private boolean binarySearch(int[][] matrix, long start, long end, int target) {
		if (start > end) return false;
		long mid = (start+end)/2;
		int compare = compare(matrix, mid, target);
		if (compare == 0) return true;
		else if (compare > 0) return binarySearch(matrix, start, mid-1, target);
		else return binarySearch(matrix, mid+1, end, target);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		return binarySearch(matrix, 0, (long)matrix.length * matrix[0].length - 1, target);
	}
}
