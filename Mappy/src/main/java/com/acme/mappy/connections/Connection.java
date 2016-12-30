package com.acme.mappy.connections;

public abstract class Connection {
	private  String from;
	private  String to;
	private  float km;
	private  int time;
	
	
	
	
	/**
	 * @return from
	 */
	public final String getFrom() {
		return from;
	}
	/**
	 * @param from
	 */
	public final void setFrom(String from) {
		this.from = from;
	}
	/**
	 * 
	 * @return
	 */
	public final String  getTo() {
		return to;
	}
	/**
	 * 
	 * @param to
	 */
	public final void setTo(String to) {
		this.to = to;
	}
	/**
	 * 
	 * @return
	 */
	public final float getKm() {
		return km;
	}
	public final void setKm(float km) {
		this.km = km;
	}
	/**
	 * 
	 * @return
	 */
	public final int  getTime() {
		return time;
	}
	/**
	 * 
	 * @param time
	 */
	public final void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * 
	 */
	public  String toString(){
		StringBuffer mySB = new StringBuffer();
		mySB = mySB.append("from: ");
		mySB.append(getFrom());
		mySB.append("\n");
		mySB.append("to: ");
		mySB.append(getTo());
		mySB.append("\n");
		mySB = mySB.append("km: ");
		mySB.append(getKm());
		mySB.append("\n");
		mySB.append("time: ");
		mySB.append(getTime());
		mySB.append("\n");
		return mySB.toString();
	}

}
