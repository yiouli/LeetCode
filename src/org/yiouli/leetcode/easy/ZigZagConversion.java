/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like 
 * this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @see <a href="https://oj.leetcode.com/problems/zigzag-conversion/">Zig Zag Conversion on LeetCode</a>
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (nRows < 2 || s == null || s.length() <= nRows) return s;
        StringBuilder buf = new StringBuilder();
        for (int n=0;n<nRows;n++) {
            for (int i=n;i<s.length();i+=2*nRows-2) {
                buf.append(s.charAt(i));
                int next = i+2*(nRows-n-1);
                if (n != 0 && n != nRows-1 && next < s.length()) buf.append(s.charAt(next));
            }
        }
        return buf.toString();
    }
}
