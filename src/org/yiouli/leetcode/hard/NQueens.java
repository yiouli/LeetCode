/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a 
 * queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *   
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 * @see <a href="https://oj.leetcode.com/problems/n-queens/">N-Queens on LeetCode</a>
 */
public class NQueens {
	private String[] arrange(int n, int[] placement) {
        String[] ret = new String[n];
        for(int i=0;i<n;i++) {
            StringBuffer buf = new StringBuffer();
            for (int j=0;j<n;j++) {
                if (j != placement[i]) buf.append('.');
                else buf.append('Q');
            }
            ret[i] = buf.toString();
        }
        return ret;
    }
    
    //pick location for all rows with index >= row
    private void pickAll(int n, int row, int[] placement, List<String[]> ret) {
        if (row == n) ret.add(arrange(n, placement));
        else {
            boolean[] attacked = new boolean[n];
            for (int i=0;i<row;i++) {
                attacked[placement[i]] = true;
                if (placement[i]+row-i < n) attacked[placement[i]+row-i] = true;
                if (placement[i]-row+i >= 0) attacked[placement[i]-row+i] = true;
            }
            for (int col=0;col<n;col++) {
                if (!attacked[col]) {
                    placement[row] = col; 
                    pickAll(n, row+1, placement, ret);
                }
            }
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]>();
        if (n != 0) {
            int[] placement = new int[n];
            pickAll(n, 0, placement, ret);
        }
        return ret;
    }
}
