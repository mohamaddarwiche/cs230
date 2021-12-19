package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class Team extends Entity {
	/**
	* A list of the active Players
	*/
	 private List<Player> players = new ArrayList<Player>();
	 
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	* Construct a new player instance
	*
	* @param name the unique player of the players
	* @return the player instance (new or existing)
	*/
	public Player addPlayer(String name) {

		// a local team instance
		Player player = null;
		Iterator<Player> playersIterator = players.iterator();
		while (playersIterator.hasNext()) {					//Iterate over list of players
			Player playerInstance = playersIterator.next();		//Set local player variable to next item in the list
			if (playerInstance.getName().equalsIgnoreCase(name)) {//If player name exist return player instance 
				player = playerInstance;
			} else {					//If player name does not exist add player name to players list
				players.add(player);
			}
		}
		return player;
	}

	@Override
	public String toString() {
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
