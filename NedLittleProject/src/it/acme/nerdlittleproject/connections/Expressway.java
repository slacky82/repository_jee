package it.acme.nerdlittleproject.connections;

public class Expressway extends Connection {
	
	public String name;
	public float safe;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSafe() {
		return safe;
	}
	public void setSafe(float safe) {
		this.safe = safe;
	}
	
	public String toString(){
		StringBuffer mySB = new StringBuffer();
		mySB = mySB.append("type: ");
		mySB = mySB.append(this.getClass().getTypeName());
		mySB.append("\n");
		mySB = mySB.append(super.toString());
		mySB = mySB.append("name: ");
		mySB.append(getName());
		mySB.append("\n");
		mySB.append("safe: ");
		mySB.append(getSafe());
		mySB.append("\n");
		mySB.append("#################\n");
		return mySB.toString();
	}
	
	

}
