package it.nerd.java.collection;

import java.util.Comparator;

public class DummyClassComparable implements Comparable<DummyClassComparable> {
	
	private String propertyS;
	private int propertyI;
	
	public DummyClassComparable(){}
	
	public DummyClassComparable(int propertyI, String propertyS){
		this.propertyI=propertyI;
		this.propertyS=propertyS;
	}
	
	/**
	 * <0  se x<y
	 * ==0 se x==y
     * >0  se x>y
	 */
	@Override
	public int compareTo(DummyClassComparable o) {
		if (o.getPropertyI()>this.propertyI) return 1;
		if (o.getPropertyI()<this.propertyI) return -1;
		return 0;
	}
	

	
	
	
	//getters mutator
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
