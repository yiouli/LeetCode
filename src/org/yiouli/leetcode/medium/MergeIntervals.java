/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * @see <a href="https://oj.leetcode.com/problems/merge-intervals/">Merge Intervals on LeetCode</a>
 */
public class MergeIntervals {

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) return ret; 
		Comparator<Interval> comp = new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start-i2.start;
			}
		};
		Collections.sort(intervals, comp);
		Interval current = null;
		for(Interval interval : intervals) {
			if (current == null || interval.start > current.end) {
				current = new Interval(interval.start, interval.end);
				ret.add(current);
			}
			else if (interval.end > current.end) current.end = interval.end;
		}
		return ret;
	}
}
