package com.xupt.queue;

import java.util.LinkedList;

public class RecentCounter {
	LinkedList<Integer> queue=new LinkedList<Integer>();
	int minIndex=0;
	public RecentCounter(){
	}
	public int ping(int t) {
		queue.offer(t);
		for(int i=minIndex;i<queue.size();i++) {
			int n=queue.get(i);
			if(n<t-3000) {
				minIndex++;
			}
		}
		return queue.size()-minIndex;
	}
	public static void main(String[] args) {
		RecentCounter obj=new RecentCounter();
		int param_1=obj.ping(1);
		int param_2=obj.ping(100);
		int param_3=obj.ping(3001);
		int param_4=obj.ping(3002);
		System.out.println(param_1+" "+param_2+" "+param_3+" "+param_4);

	}

}
