package com.xupt.stack;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String[] tokens= {"2","1","+","3","*"};
		int result=new ReversePolishSolution().evalRPN(tokens);
		System.out.println(result);
	}

}
class ReversePolishSolution{
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i< tokens.length;i++) {
			if("+".equals(tokens[i])) {
				int A=stack.pop();
				int B=stack.pop();
				stack.push(B+A);
			}
			else if("-".equals(tokens[i])) {
				int A=stack.pop();
				int B=stack.pop();
				stack.push(B-A);
			}
			else if("/".equals(tokens[i])) {
				int A=stack.pop();
				int B=stack.pop();
				stack.push(B/A);
			}
			else if("*".equals(tokens[i])) {
				int A=stack.pop();
				int B=stack.pop();
				stack.push(B*A);
			}
			else
				stack.push(Integer.parseInt(tokens[i]));
		}
		return stack.pop();
	}
}