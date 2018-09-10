package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class KeysandRooms {
	 public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
		Set<Integer> visit=new TreeSet<Integer>();
		visit.add(0);
		List<Integer> walksrooms=new ArrayList<>();
		walksrooms.add(0);
		while(walksrooms.size()>0) {
			walksrooms=getRoomsKeys1(walksrooms,visit,rooms);
		}
		
		return visit.size()==rooms.size()?true:false;
	        
	  }
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] visit=new int[rooms.size()];
		visit[0]=1;
		List<Integer> walksrooms=new ArrayList<>();
		walksrooms.add(0);
		while(walksrooms.size()>0) {
			walksrooms=getRoomsKeys(walksrooms,visit,rooms);
		}
		for(int i=0;i<visit.length;i++) {
			if(visit[i]==0) {
				return false;
			}
		}
		return true;
		 
	 }
	private List<Integer> getRoomsKeys(List<Integer> walksrooms, int[] visit, List<List<Integer>> rooms) {
		List<Integer> allkeys=new ArrayList<>();
		for(int i=0;i<walksrooms.size();i++ ) {
			List<Integer> keys=rooms.get(walksrooms.get(i));
			for(int j=0;j<keys.size();j++) {
				if(visit[keys.get(j)]!=1) {
					allkeys.add(keys.get(j));
					visit[keys.get(j)]=1;
				}
			}
		}
		return allkeys;
	}
	private List<Integer> getRoomsKeys1(List<Integer> walksrooms, Set<Integer> visit, List<List<Integer>> rooms) {
		List<Integer> allkeys=new ArrayList<>();
		for(int i=0;i<walksrooms.size();i++ ) {
			List<Integer> keys=rooms.get(walksrooms.get(i));
			for(int j=0;j<keys.size();j++) {
				if(!visit.contains(keys.get(j))) {
					allkeys.add(keys.get(j));
					visit.add(keys.get(j));
				}
			}
		}
		return allkeys;
	}
	@Test
	public void test() {
		
	}
}
