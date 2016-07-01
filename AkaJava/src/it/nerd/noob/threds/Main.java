package it.nerd.noob.threds;

import java.lang.Thread.State;

/**
 * @author fabrizio
 * In Java, processes correspond to a running Java Virtual Machine (JVM) 
 * whereas threads live within the JVM and can be created and stopped 
 * by the Java application dynamically at runtime.
 * States of Thread are: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadPing pingContainer = new ThreadPing();
		Thread ping = new Thread(pingContainer);
		ping.start();
		Thread.sleep(2);
		pingContainer.shutDown();		
	}

}
