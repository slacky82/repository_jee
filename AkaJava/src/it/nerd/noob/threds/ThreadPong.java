package it.nerd.noob.threds;

import java.lang.Thread.State;
import java.util.Date;

public class ThreadPong implements Runnable {
	private volatile boolean  done = false;

	public void shutDown(){
		done = true;	
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		long threadId = Thread.currentThread().getId();
		int threadPriority = Thread.currentThread().getPriority();
		State threadState = Thread.currentThread().getState();
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		while (!done) {
			System.out.println(new Date() + " PONG");
		}

	}

}
