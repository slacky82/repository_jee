package it.acme.nerdlittleproject.connections;

public abstract class Connection {
	private String from;
	private String to;
	private float km;
	private int time;
	
	
	//getters setters
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public float getKm() {
		return km;
	}
	public void setKm(float km) {
		this.km = km;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String toString(){
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
