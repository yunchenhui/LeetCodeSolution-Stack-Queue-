package com.xupt.bfs;

import java.util.LinkedList;
public class OpenLock {
	public static void main(String[] args) {
		String[] deadends= {"0001"};
		String target="0002";
		int step=new Solution().openLock(deadends, target);
		System.out.println("最少需要尝试的次数为"+step);
	}
}
class Node{
	int x;
	int y;
	int z;
	int k;
	int dis;
	Node(int x,int y,int z,int k,int dis){
		this.x=x;
		this.y=y;
		this.z=z;
		this.k=k;
		this.dis=dis;
	}
}
class Solution{
	public int openLock(String[] deadends,String target) {
		int[][] direction= {{1,0,0,0},{-1,0,0,0},{0,1,0,0},{0,-1,0,0},{0,0,1,0},{0,0,-1,0},{0,0,0,1},{0,0,0,-1}};
		int[][][][] mark= new int[10][10][10][10];
		LinkedList<Node> queue=new LinkedList<Node>();
		Node start=new Node(0,0,0,0,0);
		mark[0][0][0][0]=1;
		queue.offer(start);
		Node temp=null;
		String str;
		while(!queue.isEmpty()) {
			temp=queue.poll();
			int i=0;
			ok1:
			for(;i<8;i++) {
				int newX=temp.x+direction[i][0];
				int newY=temp.y+direction[i][1];
				int newZ=temp.z+direction[i][2];
				int newK=temp.k+direction[i][3];
				if(newX==-1) 
					newX=9;
				if(newY==-1) 
					newY=9;
				if(newZ==-1) 
					newZ=9;
				if(newK==-1) 
					newK=9;
				if(newX==10)
					newX=0;
				if(newY==10)
					newY=0;
				if(newZ==10)
					newZ=0;
				if(newK==10)
					newK=0;

				if (mark[newX][newY][newZ][newK]==0) {
					str = Integer.toString(newX)+Integer.toString(newY)+Integer.toString(newZ)+Integer.toString(newK);
					Node next = new Node(newX, newY, newZ, newK, temp.dis + 1);
					for (String s : deadends) {
						if (s.equals("0000"))
							return -1;
						if (s.equals(str)) {
							continue ok1;
						}
					}
					if (target.equals(str)) {
						return next.dis;
					} 
					mark[newX][newY][newZ][newK] = 1;
					queue.offer(next);					
				}
			}
		}
		return -1;
	}
}
