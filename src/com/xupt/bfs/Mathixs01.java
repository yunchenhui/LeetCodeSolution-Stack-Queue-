package com.xupt.bfs;

import java.util.LinkedList;

public class Mathixs01 {

	public static void main(String[] args) {
		int[][] matrix= {{0,0,0},{0,1,0},{0,0,0}};
		int[][] result=new Mathixs01Solution().updateMatrix(matrix);
		
	}

}
class Mathixs01Solution{
	class Node{
		int x;
		int y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public int[][] updateMatrix(int[][] matrix){
		LinkedList<Node> queue=new LinkedList<Node>();
		int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
		if(matrix==null||matrix[0].length==0)
			return matrix;
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]!=0)
					matrix[i][j]=Integer.MAX_VALUE;
				else {
					Node point=new Node(i,j);
					queue.offer(point);
				}
			}
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			for(int i=0;i<=3;i++) {
				int newX=temp.x+direction[i][0];
				int newY=temp.y+direction[i][1];
				if (newX<0&&newX>=matrix.length&&newY<0&&newY>=matrix[0].length&&matrix[newX][newY]>matrix[temp.x][temp.y]+1) {
					matrix[newX][newY] = matrix[temp.x][temp.y] + 1;
					Node next = new Node(newX, newY);
					queue.offer(next);
				}
			}
		}
		return matrix;
	}
}