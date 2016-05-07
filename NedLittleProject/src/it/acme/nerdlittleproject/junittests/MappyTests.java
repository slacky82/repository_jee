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
import it.acme.nerdlittleproject.utils.CompareKm;
import it.acme.nerdlittleproject.utils.CompareTime;

public class MappyTests {
	
	//test last commit
	
	MainRoad myConn1 = new MainRoad();
	MainRoad myConn1a = new MainRoad();
	Motorway myConn2 = new Motorway();
	Motorway myConn2a = new Motorway();
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
		
		//-----------
		myConn1a.setFrom("pescara");
		myConn1a.setTo("l'aquila");
		myConn1a.setKm(100);
		myConn1a.setTime(30);
		myConn1a.setTrafficLight(false);
		
		myConn2a.setFrom("l'aquila");
		myConn2a.setTo("roma");
		myConn2a.setKm(100);
		myConn2a.setTime(60);
		myConn2a.setPrice(new Float("12.50"));
				
		//-----------
		
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
		
		dummyMappy.add(myConn1a);
		dummyMappy.add(myConn2a);
		dummyMappy.addItinerary();
		
		dummyMappy.add(myConn3);
		dummyMappy.add(myConn4);
		dummyMappy.add(myConn5);
		dummyMappy.addItinerary();
		
		//dummyMappy.printItineraryDummy();

		Itinerary itinerary = dummyMappy.getItinerary("pescara", "roma");
		Itinerary itinerary2 = dummyMappy.getItinerary("pescara", "roma", new CompareTime());
		System.out.println(itinerary2.toString());
		
		assertNotNull(itinerary);
		assertNotNull(itinerary2);
		assertTrue(itinerary2.getTime() == 90);
	}
	
	

}
