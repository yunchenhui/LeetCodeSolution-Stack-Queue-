package com.xupt.stack;

import java.util.Stack;

public class DecodedString {

	public static void main(String[] args) {
		String s="2[abc]3[cd]ef";
		System.out.println(new DecodedSolution().decodeString(s));
	}

}
class DecodedSolution{
	private static boolean isChar(char c) {
		if(c>='a'&&c<='z')
			return true;
		return false;
	}
	public String decodeString(String s) {
		Stack<StringBuffer> stack1=new Stack<StringBuffer>();
		Stack<Integer> stack2=new Stack<Integer>();
		StringBuffer str=new StringBuffer("");
		stack1.push(str);
		int location=0;
		for(int i=0;i<s.length();i++) {
			if(isChar(s.charAt(i))) {
				stack1.peek().append(s.charAt(i));
				location=i+1;
			}
			else if(s.charAt(i)=='[') {
				StringBuffer str1=new StringBuffer("");
				stack1.push(str1);
				int n=Integer.parseInt(s.substring(location, i));
				stack2.push(n);
				location=i+1;
			}
			else if(s.charAt(i)==']') {
				int k=stack2.pop();
				StringBuffer sb=stack1.pop();
				for(int j=0;j<k;j++) {
					stack1.peek().append(sb);
				}
				location=i+1;
			}
		}
		return stack1.pop().toString();
	}

}