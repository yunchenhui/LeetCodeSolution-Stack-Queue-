package com.xupt.stack;

import java.util.Stack;

public class DailyTemperatures2 {

	public static void main(String[] args) {
		int[] temperatures= {73,74,75,71,69,72,76,73};
		int[] result=new DailySolution().dailyTemperatures(temperatures);
		for(int i:result)
			System.out.println(i);
	}

}
class DailySolution{
    public int[] dailyTemperatures(int[] temperatures) {
    	Stack<Integer> stack=new Stack<Integer>();
    	int[] result=new int[temperatures.length];
    	for(int i=0;i<temperatures.length;i++) {
    		while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]) {
    			result[stack.peek()]=i-stack.peek();
    			stack.pop();
    		}
    		stack.push(i);
    	}
    	return result;
    }
}