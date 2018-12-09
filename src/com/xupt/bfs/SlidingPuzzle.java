package com.xupt.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SlidingPuzzle {

	public static void main(String[] args) {
		int[][] board= {{1,2,3},{5,4,0}};
		System.out.println(new Solve().slidingPuzzle(board));
	}

}
class Solve {
    LinkedList<Node> queue=new LinkedList<Node>();
    class Node{
        int x;
        int y;
        int dis;
        StringBuffer station;
        Node(int x,int y,int dis,StringBuffer station){
            this.x=x;
            this.y=y;
            this.dis=dis;
            this.station=station;
        }
    }
    public int slidingPuzzle(int[][] board) {
        int x=-1;
        int y=-1;
        int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        StringBuffer str=new StringBuffer();
        Set<String> vis=new HashSet<String>();
        Node temp=null;
        for(int i=0;i<=1;i++)
            for(int j=0;j<=2;j++){
                str.append(board[i][j]);
                if(board[i][j]==0){
                    x=i;
                    y=j;
                }
            }
        vis.add(str.toString());
        Node start=new Node(x,y,0,str);
        queue.offer(start);
        while(!queue.isEmpty()){
            temp=queue.poll();
            if("123450".equals(temp.station.toString()))
                return temp.dis;
            for(int i=0;i<=3;i++){
                StringBuffer midstr=new StringBuffer(temp.station);
                int newX=temp.x+direction[i][0];
                int newY=temp.y+direction[i][1];
                if(newX<0||newX>1||newY<0||newY>2)
                    continue;
                int strNew=newX*3+newY;
                int strOld=temp.x*3+temp.y;
                String location=midstr.substring(strNew,strNew+1);
                midstr.replace(strNew,strNew+1,"0");
                midstr.replace(strOld,strOld+1,location);
                if (!vis.contains(midstr.toString())) {
					Node next = new Node(newX, newY, temp.dis + 1, midstr);
					vis.add(midstr.toString());
					queue.offer(next);
				}
            }
        }
        return -1;
    }
}
//class Solve{
//	LinkedList<Node> queue=new LinkedList<Node>();
//	class Node{
//		int x;
//		int y;
//		int dis;
//		StringBuffer station;
//		Node(int x,int y,int dis,StringBuffer station){
//			this.x=x;
//			this.y=y;
//			this.dis=dis;
//			this.station=station;
//		}
//	}
//	public int slidingPuzzle(int[][] board) {
//		int x = -1;
//		int y = -1;
//		int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};
//		StringBuffer str=new StringBuffer();
//		Node temp=null;
//		for(int i=0;i<=1;i++)
//			for(int j=0;j<=2;j++) {
//				str.append(board[i][j]);
//				if(board[i][j]==0) {
//					x=i;
//					y=j;
//				}
//			}
//		Node start=new Node(x,y,0,str);
//		queue.offer(start);
//		while(!queue.isEmpty()) {
//			temp=queue.poll();
//			if("123450".equals(temp.station.toString()))
//				return temp.dis;
//			for(int i=0;i<=3;i++) {
//				StringBuffer midstr=new StringBuffer(temp.station);
//				int newX=temp.x+direction[i][0];
//				int newY=temp.y+direction[i][1];
//				if(newX<0||newX>1||newY<0||newY>2)
//					continue;
//				int strX=newX*3+newY;
//				int strOld=temp.x*3+temp.y;
//				String location=midstr.substring(strX, strX+1);
//				midstr.replace(strOld, strOld+1, location);
//				midstr.replace(strX, strX+1, "0");
//				Node next=new Node(newX,newY,temp.dis+1,midstr);
//				queue.offer(next);
//			}
//		}
//		return -1;
//		
//	}
//}