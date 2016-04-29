package it.acme.nerdlittleproject.junittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.acme.nerdlittleproject.Mappy;
import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.connections.MainRoad;
import it.acme.nerdlittleproject.connections.Motorway;
import it.acme.nerdlittleproject.exception.InvalidItinerary;
import it.acme.nerdlittleproject.exception.NoSuchItinerary;
import it.acme.nerdlittleproject.itineraries.EmptyItinerary;
import it.acme.nerdlittleproject.itineraries.Itinerary;

public class MappyTests {
	
	//test last commit
	
	MainRoad myConn1 = new MainRoad();
	Motorway myConn2 = new Motorway();
	MainRoad myConn3 = new MainRoad();
	MainRoad myConn4 = new MainRoad();
	MainRoad myConn5 = new MainRoad();


	@Before
	public void setUp() throws Exception {

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
		myConn3.setTo("teramo");
		myConn3.setKm(100);
		myConn3.setTime(60);
		myConn3.setTrafficLight(true);
		
		myConn4.setFrom("roma");
		myConn4.setTo("teramo");
		myConn4.setKm(110);
		myConn4.setTime(50);
		myConn3.setTrafficLight(false);
		
		myConn5.setFrom("teramo");
		myConn5.setTo("bracciano");
		myConn5.setKm(100);
		myConn5.setTime(50);
		myConn5.setTrafficLight(false);
	}

	@Test
	public void test() throws InvalidItinerary, NoSuchItinerary {
		Mappy dummyMappy = new Mappy();
		dummyMappy.add(myConn1);
		dummyMappy.add(myConn2);
		dummyMappy.addItinerary();
		dummyMappy.add(myConn3);
		dummyMappy.add(myConn4);
		dummyMappy.add(myConn5);
		dummyMappy.addItinerary();
		//dummyMappy.add(myConn5);
		
		dummyMappy.printItinerary();
		
		System.out.println("TOT. TIME: " +  dummyMappy.itineraries.get(0).getTime());
		System.out.println("TOT. KM: " +    dummyMappy.itineraries.get(0).getKilometer());
		System.out.println("TOT. PRICE: " + dummyMappy.itineraries.get(0).getPrice());
		
		Itinerary itinerary = dummyMappy.getItinerary("pescara", "roma");
		assertNotNull(itinerary);
		
	}
	
	

}
