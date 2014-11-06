package it.nerd.java.collection;

import java.util.Comparator;


public class DummyClassComparator implements Comparable<DummyClassComparable> {
	
	
	public static class comparatorByPropertyI implements Comparator<DummyClassComparator> {
		/**
		 * <0  se x<y
		 * ==0 se x==y
	     * >0  se x>y
		 */
		@Override
		public int compare(DummyClassComparator x, DummyClassComparator y) {
			if (x.getPropertyI()>y.getPropertyI()) return 1;
			if (x.getPropertyI()<y.getPropertyI()) return -1;
			return 0;
		}
		
	}
	
	
	public static class comparatorByPropertyS implements Comparator<DummyClassComparator> {
		/**
		 * <0  se x<y
		 * ==0 se x==y
	     * >0  se x>y
		 */
		@Override
		public int compare(DummyClassComparator x, DummyClassComparator y) {			
			return x.getPropertyS().compareToIgnoreCase(y.getPropertyS());
		}
		
	}

	private String propertyS;
	private int propertyI;

	public DummyClassComparator(int propertyI, String propertyS) {
		this.propertyI = propertyI;
		this.propertyS = propertyS;
	}

	public DummyClassComparator() {
	}

	@Override
	public int compareTo(DummyClassComparable o) {
		// TODO Auto-generated method stub
		return 0;
	}

	// getters mutator
	public String getPropertyS() {
		return propertyS;
	}

	public void setPropertyS(String propertyS) {
		this.propertyS = propertyS;
	}

	public int getPropertyI() {
		return propertyI;
	}

	public void setPropertyI(int propertyI) {
		this.propertyI = propertyI;
	}

}
