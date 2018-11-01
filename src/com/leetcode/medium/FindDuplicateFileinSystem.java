package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class FindDuplicateFileinSystem {
    /*
     * No order is required for the final output.
		You may assume the directory name, file name and file content only has letters and digits, and the length of file content is in the range of [1,50].
		The number of files given is in the range of [1,20000].
		You may assume no files or directories share the same name in the same directory.
		You may assume each given directory info represents a unique directory. Directory path and file info are separated by a single blank space.
     */
    public List<List<String>> findDuplicate(String[] paths) {
        if(paths==null) {
        	return null;
        }
        //格式验证是个问题
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<paths.length;i++) {
        	if(paths[i]!=null&&!paths[i].equals("")) {
        		String[] strs=paths[i].split("\\s+");
            	if(strs.length<2) {
            		continue;
            	}
            	String dic=strs[0];
            	for(int j=1;j<strs.length;j++) {
            		//分离出 filename content
            		String[] parts=divide(strs[j]);
            		String file=parts[0];
            		String content=parts[1];
            		String path=dic+"/"+file;
            		List<String> list=map.get(content);
            		if(list==null) {
            			list=new ArrayList<String>();
            			list.add(path);
                		map.put(content, list);
            		}else {
            			list.add(path);
            		}
            	}
        	}
        	
        }
        List<List<String>> returnlist=new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:map.entrySet()) {
        	returnlist.add(entry.getValue());
        }
        return returnlist;
    }
    private String[] divide(String str) {
    	String[] strs=new String[2];
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		boolean can1=true;
		boolean can2=false;
		for(int k=0;k<str.length();k++) {
			if(can1) {
				if(str.charAt(k)!='(') {
					sb1.append(str.charAt(k));
				}else {
					can1=false;
					can2=true;
					continue;
				}
			}
			if(can2) {
				if(str.charAt(k)!=')') {
					sb2.append(str.charAt(k));
				}else {
					can2=false;
					break;	
				}
			}
		}
		strs[0]=sb1.toString();
		strs[1]=sb2.toString();
		return strs;
	}
    /*
     *  Input:
		["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
		Output:  
		[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
     */
	@Test
    public void test() {
    	String paths[]= {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
    	List<List<String>> list = findDuplicate(paths);
    	for(int i=0;i<list.size();i++) {
    		List<String> strs=list.get(i);
    		for(int j=0;j<strs.size();j++) {
    			System.out.print(strs.get(j)+" ");
    		}
    		System.out.println();
    	}
    }
}
