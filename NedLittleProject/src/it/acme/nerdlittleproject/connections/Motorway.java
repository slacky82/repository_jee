package it.acme.nerdlittleproject.connections;

public class Motorway extends Connection {
	
	private int number;
	private float price;
	
	//getter setter
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
		mySB.append("price: ");
		mySB.append(getPrice());
		mySB.append("\n");
		mySB.append("#################\n");
		return mySB.toString();
	}
	

}
