package it.nerd.noob.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DummyHashSet {
	
	public static void main(String[] args){
		Set<Integer> mySet = new HashSet<Integer>();
		List<Integer> myList = new ArrayList<Integer>();
		mySet.add(2);
		mySet.add(3);
		mySet.add(1);
		
		myList.add(2);
		myList.add(3);
		myList.add(1);
		
		System.out.println("mySet: "+mySet);
		System.out.println("myList: "+myList);
		
		
		
	}

}
