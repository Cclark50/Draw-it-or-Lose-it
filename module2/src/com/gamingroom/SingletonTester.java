package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");

		//Using this singleton here allows us to essentially pass the data from the main
		//into another object without explicitly passing it as an argument
		//this allows us to have a class that can hold and manipulate data that can be accessed
		//from anywhere, and makes sure that only one instance of this class can ever be created.
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
