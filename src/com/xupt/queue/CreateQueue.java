package com.xupt.queue;

import java.util.ArrayList;
import java.util.List;

class MyQueue{
	private List<Integer> data;
	private int p_start;
	public MyQueue() {
		data=new ArrayList<Integer>();
		p_start=0;
	}
	public boolean enQueue(int x) {
		data.add(x);
		return true;
	}
	public boolean isEmpty() {
		return p_start>=data.size();
	}
	public boolean deQueue() {
		if(isEmpty()!=true) {
			p_start++;
			return true;
		}
		return false;
	}
	public int front() {
		return data.get(p_start);
	}
	public void size() {
		System.out.println(data.size());
	}
}
public class CreateQueue {

	public static void main(String[] args) {
		MyQueue queue=new MyQueue();
		queue.enQueue(5);
		queue.deQueue();
		queue.size();
		System.out.println(queue.deQueue());
//		queue.enQueue(5);
//		queue.enQueue(4);
//		queue.enQueue(3);
//		queue.enQueue(2);
//		queue.enQueue(1);	
//		queue.enQueue(0);
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		queue.deQueue();
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		queue.deQueue();
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		queue.deQueue();
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		queue.deQueue();
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		queue.deQueue();
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		queue.deQueue();
//		if(queue.isEmpty()!=true) {
//			System.out.println(queue.front());
//		}
//		
	}

}
