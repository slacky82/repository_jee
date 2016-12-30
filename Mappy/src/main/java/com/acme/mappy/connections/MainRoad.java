package com.acme.mappy.connections;

public class MainRoad extends Connection {
	private int number;
	private boolean trafficLight;
	
	public final int getNumber() {
		return number;
	}
	public final void setNumber(int number) {
		this.number = number;
	}
	public final boolean isTrafficLight() {
		return trafficLight;
	}
	public final void setTrafficLight(boolean trafficLight) {
		this.trafficLight = trafficLight;
	}
	
	public String toString(){
		StringBuffer mySB = new StringBuffer();
		mySB = mySB.append("type: ");
		mySB = mySB.append(this.getClass().getTypeName());
		mySB.append("\n");
		mySB = mySB.append(super.toString());
		mySB = mySB.append("number: ");
		mySB.append(getNumber());
		mySB.append("\n");
		mySB.append("trafficLight: ");
		mySB.append(isTrafficLight());
		mySB.append("\n");
		mySB.append("#################\n");
		return mySB.toString();
	}
	
	
	
}
