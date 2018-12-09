package com.xupt.stack;

import java.util.Stack;

public class DailyTemperature {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		System.out.println(stack.peek());
		int[] temperatures= {73,74,75,71,69,72,76,73};
		int[] days=new Solution123().dailyTemperature(temperatures);
		for(int i:days) {
			System.out.print(i+" ");
		}
	}

}
class Solution123{
	public int[]  dailyTemperature(int[] temperatures) {
		Stack<Integer> stack=new Stack<Integer>();
		int temperature=0;
		int[] days=new int[temperatures.length];
		for(int i=0;i<temperatures.length;i++) {
			temperature=temperatures[i];
			for(int j=i;j<temperatures.length;j++) {
				if(temperature>=temperatures[j]) {
					stack.push(temperatures[j]);
				}
				else{
					days[i] = stack.size();
					break;
				}
			}
			stack.clear();
		}
		return days;
	}
}