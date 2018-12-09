package com.xupt.bfs;

import java.util.LinkedList;
public class MiGong{
	public static void main(String[] args) {
		int[][] arr= {{1,0,0,0,0},
					  {1,1,0,1,0},
					  {0,0,0,1,0},
					  {0,1,1,1,0},
					  {0,0,0,0,0}
					 };
		new MiGong().findMinMethod(arr);
	}
	class Node{
		int x;
		int y;
		int dis;
		Node pre;
		Node(int x,int y,int dis,Node pre){
			this.x=x;
			this.y=y;
			this.dis=dis;
			this.pre=pre;
		}
	}
	public void findMinMethod(int[][] arr) {
		int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
		LinkedList<Node> queue=new LinkedList<Node>();
		Node start=new Node(0,1,0,null);
		arr[0][1]=1;
		queue.offer(start);
		Node temp=null;
		ok:
		while(!queue.isEmpty()) {
			temp=queue.poll();
			for(int i=0;i<4;i++) {
				 int newX=temp.x+direction[i][0];
				 int newY=temp.y+direction[i][1];
				 if(newX<0||newY<0||newX>=arr.length||newY>=arr[0].length)
					 continue;
				 if(arr[newX][newY]==1)
					 continue;
				 Node next=new Node(newX,newY,temp.dis+1,temp);
				 if(newX==arr.length-1&&newY==arr[0].length-1) {
					 System.out.println("最短长度为"+(next.dis+1));
					 queue.clear();
					 queue.offerFirst(next);
					 Node preNode=next.pre;
					 while(preNode!=null) {
						 queue.offerFirst(preNode);
						 preNode=preNode.pre;
					 }
					 for(Node it:queue) {
						 System.out.println("("+it.x+","+it.y+")");
					 }
					 break ok;
				 }
				 arr[newX][newY]=1;
				 queue.offer(next);
			}
		}
	}
}