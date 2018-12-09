package com.xupt.queue;
class MyCircularQueue{
	private int[] data;
	private int head;
	private int tail;
	private int size;
	MyCircularQueue(int x){
		data=new int[x];
		head=-1;
		tail=-1;
		size=x;
	}
	public boolean isEmpty(){
		return head==-1;
	}
	public boolean isFull() {
		if((tail+1)%size==head)
			return true;
		else 
			return false;
	}
	public boolean enQueue(int x) {
		if(isFull()) {
			return false;
		}
		if(isEmpty()) head=0;
		tail=(tail+1)%size;
		data[tail]=x;
		return true;
	}
	public boolean deQueue() {
		if(isEmpty())
			return false;
		if(head==tail) {
			head=tail=-1;
			return true;
		}
		head=(head+1)%size;
		return true;
	}
	public int front() {
		if(isEmpty())
			return -1;
		return data[head];
	}
	public int rear() {
		if(isEmpty())
			return -1;
		return data[tail];
	}
}
public class CreateCircularQueue {

	public static void main(String[] args) {
		MyCircularQueue mq=new MyCircularQueue(3);
		System.out.println(mq.enQueue(0));
		System.out.println(mq.enQueue(1));
		System.out.println(mq.enQueue(2));
		System.out.println(mq.enQueue(3));
		System.out.println(mq.front());
		System.out.println(mq.rear());
		System.out.println(mq.isFull());
		System.out.println(mq.deQueue());
		System.out.println(mq.enQueue(4));
		System.out.println(mq.front());
		System.out.println(mq.rear());

	}

}
