package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	/**
	* A list of the active teams
	*/
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	* Construct a new team instance
	*
	* @param name the unique name of the team
	* @return the team instance (new or existing)
	*/
	public Team addTeam(String name) {

		// a local team instance
		Team team = null;
		Iterator<Team> teamsIterator = teams.iterator();
		while (teamsIterator.hasNext()) {					//Iterate over list of teams
			Team teamInstance = teamsIterator.next();		//Set local team variable to next item in the list
			if (teamInstance.getName().equalsIgnoreCase(name)) {//If team name exist return team instance 
				team = teamInstance;
			} else {					//If team name does not exist add team name to teams list
				teams.add(team);
			}
		}
		return team;
	}

	@Override
	public String toString() {
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
