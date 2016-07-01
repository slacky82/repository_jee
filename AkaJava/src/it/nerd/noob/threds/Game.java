package it.nerd.noob.threds;

public class Game {
	
	public static void main(String[] args){
		
		PingPong table = new PingPong();
		Thread mario = new Thread(new Player("luigi", table));
		Thread luigi = new Thread(new Player("mario", table));
		
		mario.setName("mario");
		luigi.setName("luigi");
		mario.start();
		luigi.start();
		
//		try{
//			Thread.currentThread().wait(5000);
//		}catch(InterruptedException ie){
//			ie.printStackTrace();
//		}
		
		//table.hit("DONE");
		
//		try{
//			Thread.currentThread().sleep(100);
//		}catch (InterruptedException ie){
//			ie.printStackTrace();
//		}
	}

}
