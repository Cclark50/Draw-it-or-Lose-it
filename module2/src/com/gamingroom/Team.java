package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{

	//List of all Players for this specific team
	private ArrayList<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	public Player addPlayer(String name) {
		Iterator<Player> playerIt = players.iterator();
		Player player = null;

		while(playerIt.hasNext()) {
			player = playerIt.next();
			if(player.getName().equals(name)) {
				return player;
			}
		}

		player = new Player(GameService.getInstance().getNextPlayerId(), name);
		players.add(player);
		return player;
	}

	@Override
	public String toString() {
		return "Team" + super.toString();
	}
}
