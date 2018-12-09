package com.xupt.bfs;

import java.util.*;


public class GetInstance {
	public static void main(String[] args) {
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] mark=new int[4][4];
		new GetInstance().BFS(arr,mark);
		
	}
	class Node{
		int x;
		int y;
		int dis;
		Node(int x,int y,int dis){
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
	}
	public void BFS(int[][] arr,int[][] mark) {
		Map<Integer, Integer> map=new TreeMap<Integer,Integer>();
		LinkedList<Node> queue=new LinkedList<Node>();
		Node start=new Node(0,0,0);
		mark[0][0]=1;
		map.put(1, 0);
		queue.offer(start);
		Node temp=null;
		int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
		while(!queue.isEmpty()) {
			temp=queue.poll();
			for(int i=0;i<4;i++) {
				int newX=temp.x+direction[i][0];
				int newY=temp.y+direction[i][1];
				if(newX<0||newX>=arr.length||newY<0||newY>=arr[0].length)
					continue;
				if(mark[newX][newY]==1)
					continue;
				mark[newX][newY]=1;
				Node next=new Node(newX,newY,temp.dis+1);
				map.put(arr[newX][newY], next.dis);
				queue.offer(next);
			}
		}
		for(Map.Entry<Integer,Integer> it:map.entrySet()) {
			System.out.println("1->"+it.getKey()+":"+it.getValue());
		}
	}
}
