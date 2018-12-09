package com.xupt.queue;

import java.util.*;
public class CreateAutoQueue {

	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList();
		System.out.println("The first element is "+q.peek());
		q.offer(0);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll();
		System.out.println("The first element is "+q.peek());
		System.out.println(q.size());
	}

}
