package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * Holds the next player Id and team Id
	 */
	private static long nextPlayerId = 1;

	private static long nextTeamId = 1;

	//Creates an instance of a GameService and stores it in itself
	private static GameService instance = new GameService();

	//We keep the constructor private so no other users or objects can create an instance of
	//GameService. This allows us to guarantee that there will only ever be one instance
	private GameService() {}

	//This allows users and objects to get the one instance of GameService so they can use
	//the data and datastructures inside, allowing us to have data shipped across the
	//program for other users and objects to gain access to.
	public static GameService getInstance() {
		return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// if found, simply return the existing instance

		/*
		Creates an iterator of the games arraylist and stores it
		The iterator is a pattern that allows us to iterate through a list
		in such a way that we can use an object instead of having to create a for loop
		This is a more convenient and easy way to iterate through a list and
		prevents mathematical errors
		Iterators also allow foreach loops to be used and makes for even more
		ease of use.
		*/
		Iterator<Game> gameIt = games.iterator();
		//We create a temporary variable since if game is not null by the end then
		//the function returns an incorrect value
		Game currGame;

		while(gameIt.hasNext()) {
			currGame = gameIt.next();
			if(currGame.getName().equals(name)) {
				return currGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// if found, simply assign that instance to the local variable

		//same as above
		Iterator<Game> gameIt = games.iterator();
		Game currGame;

		while(gameIt.hasNext()) {
			currGame = gameIt.next();
			if(currGame.getId() == id) {
				game = currGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// if found, simply assign that instance to the local variable

		//the exact same as above
		Iterator<Game> gameIt = games.iterator();
		Game currGame;

		while(gameIt.hasNext()) {
			currGame = gameIt.next();
			if(currGame.getName().equals(name)) {
				game = currGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	//These do a combination of getting the currently unused player or team id
	//then afterward will add 1 to that specific id variable, thereby
	//allowing us to never be allowed to use that specific id again
	//keeping each id unique
	public long getNextPlayerId() {
		return nextPlayerId++;
	}

	public long getNextTeamId() {
		return nextTeamId++;
	}
}
