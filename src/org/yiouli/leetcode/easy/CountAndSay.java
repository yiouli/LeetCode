/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

import java.util.ArrayList;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * @see <a href="https://oj.leetcode.com/problems/count-and-say/">Count and Say on LeetCode</a>
 */
public class CountAndSay {

	/**
	 * Count and say sequence of integers for one time.
	 * @param seq is sequence of integers. Each integer in sequence should be positive. 
	 * 		      Size of sequence should be positive.
	 * @return result sequence of count and say.
	 */
	private ArrayList<Integer> countAndSay(ArrayList<Integer> seq) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int last = seq.get(0), count = 1, size = seq.size();
		for (int i = 1; i < size; i++) {
			int m = seq.get(i);
			if (m == last) count++;
			else {
				ret.add(count);
				ret.add(last);
				count = 1;
				last = m;
			}
		}
		ret.add(count);
		ret.add(last);
		return ret;
	}
	
	public String countAndSay(int n) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(1);
		for (int i = 1; i < n; i++) {
			seq = countAndSay(seq);
		}
		StringBuffer buf = new StringBuffer();
		for (int digit : seq) {
			buf.append(digit);
		}
		return buf.toString();
    }
}
