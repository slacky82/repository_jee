package it.nerd.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

	private static DummyClassComparable myDummy0 = new DummyClassComparable(0, "A");
	private static DummyClassComparable myDummy1 = new DummyClassComparable(1, "B");
	private static DummyClassComparable myDummy2 = new DummyClassComparable(2, "C");
	private static DummyClassComparable myDummy3 = new DummyClassComparable(2, "C");	

	private static DummyClassComparator myDummy4 = new DummyClassComparator(0, "A");
	private static DummyClassComparator myDummy5 = new DummyClassComparator(1, "B");
	private static DummyClassComparator myDummy6 = new DummyClassComparator(2, "C");	

	public static void main(String[] args) {
		
		//COMPARABLE
		List<DummyClassComparable> myList = new ArrayList<DummyClassComparable>();
		myList.add(myDummy2);
		myList.add(myDummy0);
		myList.add(myDummy1);
		myList.add(myDummy3);

		

		System.out.println("COMPARABLE");
		System.out.println("BEFORE");		
		for (DummyClassComparable dummyClass : myList) {
			System.out.println("propertyI-> " + dummyClass.getPropertyI());
		}
		
		Collections.sort(myList);
		
		//Collections.reverse(myList);
		System.out.println("AFTER");
		for (DummyClassComparable dummyClass : myList) {
			System.out.println("propertyI-> " + dummyClass.getPropertyI());
		}
		
		
		
		//COMPARATOR
		System.out.println("COMPARATOR");		
		List<DummyClassComparator> myList2 = new ArrayList<DummyClassComparator>();
		myList2.add(myDummy6);
		myList2.add(myDummy4);
		myList2.add(myDummy5);
		
		System.out.println("BEFORE");
		
		for (DummyClassComparator dummyClass : myList2) {
			System.out.println("propertyI-> " + dummyClass.getPropertyI());
		}
		
		Collections.sort(myList2, new DummyClassComparator.comparatorByPropertyI());
		
		System.out.println("AFTER");
		
		for (DummyClassComparator dummyClass : myList2) {
			System.out.println("propertyI-> " + dummyClass.getPropertyI());
		}
		
		System.out.println("BEFORE");
		
		myList2 = new ArrayList<DummyClassComparator>();
		myList2.add(myDummy6);
		myList2.add(myDummy4);
		myList2.add(myDummy5);
		
		for (DummyClassComparator dummyClass : myList2) {
			System.out.println("propertyS-> " + dummyClass.getPropertyS());
		}	
		
		Collections.sort(myList2, new DummyClassComparator.comparatorByPropertyS());
		
		System.out.println("AFTER");
		
		for (DummyClassComparator dummyClass : myList2) {
			System.out.println("propertyS-> " + dummyClass.getPropertyS());
		}
		
		
		
		

	}

}
