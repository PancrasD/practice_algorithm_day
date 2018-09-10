package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class QueueReconstructionbyHeight {
	 public int[][] reconstructQueue(int[][] people) {
	   if(people==null){
            return null;
        }
        if(people.length==0){
            return people;
        }
		int len=people.length;
		int[][] queue=new int[len][2];
		Map<Integer,List<Integer>> mapp=new TreeMap<>();
		Map<Integer,List<Integer>> exit=new TreeMap<>();
		Map<Integer,Integer> suit=new TreeMap<>();
		int min=Integer.MAX_VALUE;
		int first=0;
		for(int i=0;i<people.length;i++) {
			if(people[i][1]==0) {
				if(people[i][0]<min) {
					min=people[i][0];
					first=i;
				}
			}
			List<Integer> list=mapp.get(people[i][0]);
			if(list==null) {
				list=new ArrayList<>();
				list.add(people[i][1]);
				mapp.put(people[i][0], list);
			}else {
				list.add(people[i][1]);
			}
		}
		List<Integer> contain=new ArrayList<>();
		for(Map.Entry<Integer, List<Integer>> entry:mapp.entrySet()) {
			contain.add(entry.getKey());
		}
		Collections.sort(contain);
		queue[0]=people[first];
		int count=1;
		int removekey=people[first][0];
		Integer removevalue=people[first][1];
		find(len,mapp,removekey,removevalue,exit,suit,queue,count,contain);
		return queue;
	 }

	private void find(int len, Map<Integer, List<Integer>> mapp, int removekey, Integer removevalue,
			Map<Integer, List<Integer>> exit, Map<Integer, Integer> suit, int[][] queue, int count, List<Integer> contain) {
		//移除
		while(count==len) {
			return;
		}
		List<Integer> list=mapp.get(removekey);
		list.remove(removevalue);
		if(list.size()==0) {
			mapp.remove(removekey);
			contain.remove((Integer)removekey);
		}
		//添加
		List<Integer> list1=exit.get(removekey);
		if(list1==null) {
			list1=new ArrayList<>();
			list1.add(removevalue);
			exit.put(removekey, list1);
		}else {
			list1.add(removevalue);
		}
		//计算
		List<Integer> listmap=new ArrayList<>();
		for(Map.Entry<Integer, List<Integer>> entry:exit.entrySet()) {
			listmap.add(entry.getKey());
		}
		Collections.sort(listmap);
		int large=0;
		suit.put(listmap.get(listmap.size()-1), exit.get(listmap.get(listmap.size()-1)).size());
		for(int i=listmap.size()-2;i>=0;i--) {
			large=suit.get(listmap.get(i+1));
			suit.put(listmap.get(i), exit.get(listmap.get(i)).size()+large);
		}
		//寻找
		boolean is=true;
		int key=0;
		int value=0;
		boolean notfind=false;
		while(is) {
			for(int i=0;i<listmap.size();i++) {
				key=listmap.get(i);
				value=suit.get(key);
				//下层
				List<Integer> suitlist=new ArrayList<>();
				for(int l=0;l<contain.size();l++) {
					if(i==0) {
						if(contain.get(l)<=key)
						suitlist.add(contain.get(l));
					}else {
						if(contain.get(l)<=key&&contain.get(l)>listmap.get(i-1)) {
							suitlist.add(contain.get(l));
						}else if(contain.get(l)>key){
							break;
						}
					}
				}
				Collections.sort(suitlist);
				for(int k=0;k<suitlist.size();k++) {
					int kk=suitlist.get(k);
					if(mapp.get(kk).contains(value)) {
						key=kk;
						queue[count][0]=kk;
						queue[count][1]=value;
						count++;
						is=false;
						break;
					}
				}
				//继续
				if(!is) {
					break;
				}
			}
			if(!is) {
				break;
			}
			is=false;
			notfind=true;
		}
		//找0
		int min=Integer.MAX_VALUE;
		if(notfind) {
			for(Map.Entry<Integer, List<Integer>>entry:mapp.entrySet()) {
				if(entry.getValue().contains(0)) {
					if(entry.getKey()<min) {
						min=entry.getKey();
						key=entry.getKey();
						value=0;
					}
				}
			}
			queue[count][0]=key;
			queue[count][1]=value;
			count++;
		}
		find(len,mapp,key,value,exit,suit,queue,count,contain);
	}
  @Test 
  public void test11() {
	  int[][]peo= {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
	  int [][] re=reconstructQueue(peo);
	  for(int i=0;i<re.length;i++) {
		  System.out.print("["+re[i][0]+" "+re[i][1]+"]"+" ");
	  }
  }
	
}
