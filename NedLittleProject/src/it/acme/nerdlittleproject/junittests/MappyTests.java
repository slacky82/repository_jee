package it.acme.nerdlittleproject.junittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.acme.nerdlittleproject.Mappy;
import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.connections.MainRoad;
import it.acme.nerdlittleproject.connections.Motorway;
import it.acme.nerdlittleproject.exception.InvalidItinerary;
import it.acme.nerdlittleproject.itineraries.EmptyItinerary;
import it.acme.nerdlittleproject.itineraries.Itinerary;

public class MappyTests {
	
	private  EmptyItinerary myItinerary;
	MainRoad myConn1 = new MainRoad();
	Motorway myConn2 = new Motorway();
	MainRoad myConn3 = new MainRoad();
	MainRoad myConn4 = new MainRoad();


	@Before
	public void setUp() throws Exception {
		
		myItinerary = Itinerary.makeEmpty();

		myConn1.setFrom("pescara");
		myConn1.setTo("l'aquila");
		myConn1.setKm(100);
		myConn1.setTime(60);
		myConn1.setTrafficLight(true);
		
		myConn2.setFrom("l'aquila");
		myConn2.setTo("roma");
		myConn2.setKm(100);
		myConn2.setTime(60);
		myConn2.setPrice(new Float("12.50"));
		
		myConn3.setFrom("roma");
		myConn3.setTo("pescara");
		myConn3.setKm(100);
		myConn3.setTime(60);
		myConn3.setTrafficLight(true);
		
		myConn4.setFrom("palermo");
		myConn4.setTo("milano");
		myConn4.setKm(100);
		myConn4.setTime(60);
		myConn4.setTrafficLight(true);
		
	}

	@Test
	public void test() throws InvalidItinerary {
		Mappy dummyMappy = new Mappy();
		dummyMappy.add(myConn1);
		dummyMappy.add(myConn2);
		dummyMappy.add(myConn3);
		//dummyMappy.add(myConn4);
		
		dummyMappy.printItinerary();
		
		System.out.println("TOT. TIME: " + dummyMappy.myItinerary.getTime());
		System.out.println("TOT. KM: " + dummyMappy.myItinerary.getKilometer());
		System.out.println("TOT. PRICE: " + dummyMappy.myItinerary.getPrice());
		
		
	}

}