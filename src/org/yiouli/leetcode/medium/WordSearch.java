/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" 
 * cells are those horizontally or vertically neighboring. The same letter cell may not be 
 * used more than once.
 * For example,
 * Given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @see <a href="https://oj.leetcode.com/problems/word-search/">Word Search on LeetCode</a>
 */
public class WordSearch {
	public boolean dfs(char[][] board, boolean[][] visited, String word, int idx, int x, int y) {
		if (idx >= word.length()) return true;
		if (word.charAt(idx) != board[x][y]) return false;
		visited[x][y]=true;
		if (idx == word.length()-1
			||(x > 0 && !visited[x-1][y] && dfs(board, visited, word, idx+1, x-1, y))
			||(x < board.length-1 && !visited[x+1][y]  && dfs(board, visited, word, idx+1, x+1, y))
			||(y > 0 && !visited[x][y-1]  && dfs(board, visited, word, idx+1, x, y-1))
			||(y < board[0].length-1 && !visited[x][y+1]  && dfs(board, visited, word, idx+1, x, y+1)))
			return true;
		visited[x][y]=false;
		return false;
	}

	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0) return false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int x=0;x<board.length;x++) {
			for (int y=0;y<board[0].length;y++) {
				if(dfs(board, visited, word, 0, x, y)) return true;
			}
		}
		return false;
	}
}
