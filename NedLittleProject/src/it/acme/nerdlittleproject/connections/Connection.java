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
	
	

}
