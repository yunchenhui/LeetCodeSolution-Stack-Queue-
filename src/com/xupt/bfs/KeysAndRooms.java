package com.xupt.bfs;

import java.util.*;

public class KeysAndRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class KeySolution{
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedList<Integer> queue=new LinkedList<Integer>();
        queue.offer(0);
        HashSet<Integer> hashset=new HashSet<Integer>();
        hashset.add(0);
        while(!queue.isEmpty()) {
        	int number=queue.poll();
        	for(Integer i:rooms.get(number)) {
        		if(!hashset.contains(i)) {
        			queue.offer(i);
        			hashset.add(i);
        			if(rooms.size()==hashset.size())
        				return true;
        		}
        	}
        }
        return rooms.size()==hashset.size();
    }
}