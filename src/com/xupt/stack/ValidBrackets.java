package com.xupt.stack;

import java.util.*;

public class ValidBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution{
	public boolean isValid(String s) {
		if(s.isEmpty())
			return true;
		char[] c=s.toCharArray();
		Stack<Character> stack= new Stack<>();
		for(char c1:c) {
			if(c1=='(')
				stack.push(')');
			else if(c1=='{')
				stack.push('}');
			else if(c1=='[')
				stack.push(']');
			else if(stack.isEmpty()||stack.pop()!=c1)
				return false;
		}
		return stack.isEmpty();
	}
}