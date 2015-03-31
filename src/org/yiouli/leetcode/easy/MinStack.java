package org.yiouli.leetcode.easy;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MinStack {

	private Stack<Integer> values = new Stack<Integer>();
	private Stack<Integer> mins = new Stack<Integer>();
	
	public void push(int val) {
		values.push(val);
		if (mins.empty() || val <= mins.peek()) mins.push(val);
	}
	
	public int pop() {
		if (values.empty()) throw new NoSuchElementException();
		int val = values.pop();
		if (mins.peek() == val) mins.pop();
		return val;
	}
	
	public int top() {
		if (values.empty()) throw new NoSuchElementException();
		return values.peek();
	}
	
	public int min() {
		if (mins.empty()) throw new NoSuchElementException();
		return mins.peek();
	}
}
