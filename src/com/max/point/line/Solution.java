package com.max.point.line;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
    	Map<Double,Set<Point>> kmap=new TreeMap<Double,Set<Point>>();
    	for(int i=0;i<points.length-1;i++) {
    		for(int j=i+1;j<points.length;j++) {
    			double k=(points[i].x-points[j].x)*1.0/(points[i].y-points[j].y);
    			Set<Point> set=kmap.get(k);
    			if(set==null) {
    				set=new TreeSet<Point>();
    				set.add(points[i]);
    				set.add(points[j]);
    			}else {
    				set.add(points[i]);
    				set.add(points[j]);
    			}
    		}
    	}
    	int maxPoints=0;
    	for(Map.Entry<Double,Set<Point>> entry:kmap.entrySet()) {
    		maxPoints=maxPoints<entry.getValue().size()?entry.getValue().size():maxPoints;
    	}
		return maxPoints;
        
    }
}