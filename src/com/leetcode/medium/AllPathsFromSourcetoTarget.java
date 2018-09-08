package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AllPathsFromSourcetoTarget {
	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		if(graph==null||graph.length==0) {
			 return null;
		 }
		List<List<Integer>> allpath=new ArrayList<>();
		int n_1Node=graph.length-1;
		for(int i=graph.length-1;i>=0;i--) {
			for(int j=0;j<graph[i].length;j++) {
				if(graph[i][j]==n_1Node) {
					List<List<Integer>> allchildpath=new ArrayList<>();
					allchildpath=findpath(i,graph);
					if(allchildpath==null||allchildpath.size()==0) {
						List<Integer> kl=new ArrayList<>();
						kl.add(i);
						kl.add(n_1Node);
						allpath.add(kl);
					}else {
						for(int k=0;k<allchildpath.size();k++) {
							List<Integer> kl=new ArrayList<>();
							kl.addAll(allchildpath.get(k));
							kl.add(i);
							kl.add(n_1Node);
							allpath.add(kl);
						}
					}
				}
			}
		}
		return allpath;
	    }

	private List<List<Integer>> findpath(int node, int[][] graph) {
		if(node==0) {
			return null;
		}
		List<List<Integer>> allchildpaths=new ArrayList<>();
		for(int i=node-1;i>=0;i--) {
			for(int j=0;j<graph[i].length;j++) {
				if(graph[i][j]==node) {
					List<List<Integer>> allchildpath=new ArrayList<>();
					allchildpath=findpath(i,graph);
					if(allchildpath==null||allchildpath.size()==0) {
						List<Integer> kl=new ArrayList<>();
						kl.add(i);
						allchildpaths.add(kl);
					}else {
						for(int k=0;k<allchildpath.size();k++) {
							List<Integer> kl=new ArrayList<>();
							kl.addAll(allchildpath.get(k));
							kl.add(i);
							allchildpaths.add(kl);
						}
					}
					
				}
			}
		}
		return allchildpaths;
	}
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
	@Test
	public void test1() {
		int[][] a= {{1,2}, {3,5}, {3,6}, {4},{5},{6},{}} ;
		long t1=System.nanoTime();
		List<List<Integer>> paths=allPathsSourceTarget(a);
		long t2=System.nanoTime();
		for(int i=0;paths!=null&&i<paths.size();i++) {
			for(int j=0;j<paths.get(i).size();j++) {
				System.out.print(paths.get(i).get(j)+"--");
			}
			System.out.println();
		}
		System.out.println(t2-t1);
	}
}
