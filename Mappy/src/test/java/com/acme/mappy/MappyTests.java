package com.acme.mappy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.acme.nerdlittleproject.Mappy;
import it.acme.nerdlittleproject.connections.Connection;
import it.acme.nerdlittleproject.connections.Expressway;
import it.acme.nerdlittleproject.connections.MainRoad;
import it.acme.nerdlittleproject.connections.Motorway;
import it.acme.nerdlittleproject.exception.InvalidItinerary;
import it.acme.nerdlittleproject.exception.NoSuchItinerary;
import it.acme.nerdlittleproject.itineraries.EmptyItinerary;
import it.acme.nerdlittleproject.itineraries.Itinerary;
import it.acme.nerdlittleproject.utils.CompareKm;
import it.acme.nerdlittleproject.utils.CompareTime;

public class MappyTests {
	
	MainRoad myConn1 = new MainRoad();
	MainRoad myConn1a = new MainRoad();
	Motorway myConn2 = new Motorway();
	Motorway myConn2a = new Motorway();
	MainRoad myConn3 = new MainRoad();
	MainRoad myConn4 = new MainRoad();
	MainRoad myConn5 = new MainRoad();
	MainRoad myConn6 = new MainRoad();
	Expressway myConn7 = new Expressway();
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
		myConn1a.setKm(90);
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
		
		myConn4.setFrom("teramo");
		myConn4.setTo("bracciano");
		myConn4.setKm(110);
		myConn4.setTime(50);
		myConn4.setTrafficLight(false);
		
		myConn5.setFrom("teramo");
		myConn5.setTo("bracciano");
		myConn5.setKm(150);
		myConn5.setTime(110);
		myConn5.setTrafficLight(false);
		
		myConn6.setFrom("bracciano");
		myConn6.setTo("teramo");
		myConn6.setKm(150);
		myConn6.setTime(110);
		myConn6.setTrafficLight(false);
		
		//--
		myConn7.setFrom("bracciano");
		myConn7.setTo("fiuggi");
		myConn7.setKm(200);
		myConn7.setName("A24");
		myConn7.setSafe(3.0f);
		myConn7.setTime(120);
		
	}
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void itineraryNotLinked() throws InvalidItinerary, NoSuchItinerary {
		Mappy dummyMappy = new Mappy();
		dummyMappy.add(myConn1);
		dummyMappy.add(myConn2);
		exception.expect(InvalidItinerary.class);
		exception.expectMessage("itinerary does not linked");
		dummyMappy.add(myConn5);
	}
	
	@Test
	public void itinerarySameCity() throws InvalidItinerary, NoSuchItinerary {
		Mappy dummyMappy = new Mappy();
		dummyMappy.add(myConn3);
		dummyMappy.add(myConn4);
		exception.expect(InvalidItinerary.class);
		exception.expectMessage("itinerary goes two times in the same city");
		dummyMappy.add(myConn6);		
	}
	
	@Test
	public void findItinerary() throws InvalidItinerary, NoSuchItinerary {
		Mappy dummyMappy = new Mappy();
		dummyMappy.add(myConn1);
		dummyMappy.add(myConn2);
		dummyMappy.add(myConn1a);
		dummyMappy.add(myConn2a);
		dummyMappy.addItinerary();
		exception.expect(NoSuchItinerary.class);
		exception.expectMessage("this itinerary does not contains this step");
		Itinerary dummyItinerary = dummyMappy.getItinerary("foo", "bar", new CompareTime());
	}	
	
	@Test
	public void compareItinerary() throws InvalidItinerary, NoSuchItinerary {
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
		dummyMappy.add(myConn7);
		dummyMappy.addItinerary();
		
		dummyMappy.printItineraryDummy();

		Itinerary itinerary = dummyMappy.getItinerary("pescara", "roma");
		Itinerary itinerary2 = dummyMappy.getItinerary("pescara", "roma", new CompareTime());
		
		//System.out.println(itinerary2.toString());
		assertNotNull(itinerary);
		assertNotNull(itinerary2);
		assertTrue(!itinerary.equals(itinerary2));
		assertTrue(itinerary2.getTime() == 90);
		assertTrue(itinerary.getTime() == 120);
	}
}
