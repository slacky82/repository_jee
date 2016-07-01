package it.nerd.noob.threds;

public class PingPong {
	
	private String whoseTurn = null;
	
	public synchronized boolean hit(String opponent){
		
		String currThreadName = Thread.currentThread().getName();
		
		if(whoseTurn!= null &&  whoseTurn.compareTo("DONE") == 0){
			return false;
		}
		if(opponent!= null && opponent.compareTo("DONE") == 0){
			notifyAll();
			return false;
		}
		
		if(whoseTurn == null){
			whoseTurn = currThreadName;
			return true;
		}
		if(currThreadName.compareTo(whoseTurn) == 0 ){
			//todo anything
			System.out.println("PING! ("+currThreadName + ")");
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			whoseTurn = opponent;
			notifyAll();
		}else{
			try{
				long t1 = System.currentTimeMillis();
				wait(2500);
				if ((System.currentTimeMillis() - t1) > 2500) {
					System.out.println("****** TIMEOUT! "+currThreadName+" is waiting for "+whoseTurn+" to play.");
				}
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		return true;
	}
}
