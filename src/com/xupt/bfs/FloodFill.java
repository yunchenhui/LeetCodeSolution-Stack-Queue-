package com.xupt.bfs;

import java.util.*;

public class FloodFill {

	public static void main(String[] args) {
		int[][] picture= {{1,1,1},{1,1,0},{1,0,1}};
		int[][] target=new FloodSolution().floodFill(picture, 1, 1, 2);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				System.out.println(target[i][j]);
	}

}
class FloodSolution{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	int[][] station=image;
    	int rows=station.length;
    	int cols=station[0].length;
    	flooddfs(station,sr,sc,rows,cols,newColor);
    	return station;
    }
    private void flooddfs(int[][] image,int sr,int sc,int rows,int cols,int newColor) {
		if(sr<0||sr>=rows||sc<0||sc>=cols)
			return;
		if(image[sr][sc]==0)
			return ;
		if(image[sr][sc]==newColor)
			return;
		image[sr][sc]=newColor;
		flooddfs(image, sr+1, sc, rows, cols, newColor);
		flooddfs(image, sr-1, sc, rows, cols, newColor);
		flooddfs(image, sr, sc+1, rows, cols, newColor);
		flooddfs(image, sr, sc-1, rows, cols, newColor);
    }
}