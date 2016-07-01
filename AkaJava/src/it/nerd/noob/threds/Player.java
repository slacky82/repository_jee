package it.nerd.noob.threds;

public class Player implements Runnable {

	PingPong myTable;
	String myOpponent;
	
	public Player(String opponent, PingPong table){
		myTable = table;
		myOpponent = opponent;
	}
	
	@Override
	public void run() {
		while(myTable.hit(myOpponent));		
	}
}
