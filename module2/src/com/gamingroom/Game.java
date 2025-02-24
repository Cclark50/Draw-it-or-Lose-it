package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	//List of all current Teams for this specific game
	public ArrayList<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		//We have to use super so that we can pass the data to Entity, since we do not have access to id and name
		//in the subclass
		super(id, name);
	}

	public Team addTeam(String name){

		//This is identical to previous addX methods using iterators
		Iterator<Team> playerIt = teams.iterator();
		Team team = null;

		while(playerIt.hasNext()) {
			team = playerIt.next();
			if(team.getName().equals(name)) {
				return team;
			}
		}

		//however, here we use the singleton so that we can access the next team id
		//which allows us to keep track of the current team ID across the entire program
		team = new Team(GameService.getInstance().getNextTeamId(), name);
		teams.add(team);
		return team;
	}

	//Since we have the data portion inside the Entity superclass, we can just prepend
	//the type of class we're using so we can print the class + data
	@Override
	public String toString() {
		return "Game" + super.toString();
	}

}
