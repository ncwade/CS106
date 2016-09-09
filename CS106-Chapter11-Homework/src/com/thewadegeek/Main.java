package com.thewadegeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	public static <T> ArrayList<T> alternate(List<T> a, List<T> b) {
	    Iterator<T> itA = a.iterator();
	    Iterator<T> itB = b.iterator();
	    ArrayList<T> combined = new ArrayList<T>();

	    while (itA.hasNext() || itB.hasNext()) {
	        if (itA.hasNext()) {
	        	combined.add(itA.next());
	        }
	        if (itB.hasNext()) {
	        	combined.add(itB.next());
	        }
	    }
	    return combined;
	}

	public static <T> void removeInRange(LinkedList<T> list, T e, int startIndex, int endIndex) {
		Iterator<T> it = list.subList(startIndex, endIndex).iterator();
		
		while(it.hasNext()) {
			if (it.next() == e) {
				it.remove();
			}
		}
	}

	public static <T> int countUnique(List<T> list){
		Set<T> set = new HashSet<T>(list);
		return set.size();
	}

	public static <T1,T2> boolean subMap(Map<T1, T2> subMap, Map<T1, T2> map) {
		boolean contains = true;
		
		for(T1 key : subMap.keySet()) {
			if(map.containsKey(key)) {
				if(subMap.get(key) == map.get(key)) {
					continue;
				}
			}
			contains = false;
		}
		
		return contains;
	}
}
