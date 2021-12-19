package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;
	
	// Create private variable service to check the existence of GameService
	private static GameService service;
	
	//Default constructor 
	private GameService() {
	}
	
	// FIXME: Add missing pieces to turn this class a singleton 
	// create a private local instance of GameService class
	//private static GameService instance = new GameService();
	
	// create a public accessor to allow other classes to access objects in GameService class 
	/**
	 * Check for existing instance of GameService
	 * @return 
	 */
	public static GameService getInstance() {
		if(service == null) {					//check if GameService exist 
			service = new GameService();		//if not create new GameService
			System.out.println("New Game Service created!");
		} else {								//if exist prompt to user 
			System.out.println("Game Service already created!");			
		}
		return service;
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

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		//go over the list of games, if found with existing name return Game instance without adding 
		Iterator<Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {							//Iterate over list of games
			Game gameInstance = gamesIterator.next();				//Set local game variable to next item in the list
			if (gameInstance.getName().equalsIgnoreCase(name)) {	//If game name exist return game instance 
				return gameInstance;								
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
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		// go over the list of games, if found with existing id return Game instance
		Iterator <Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {						//Iterate over list of games
			Game gameInstance = gamesIterator.next();			//Set local game variable to next item in the list
			if (gameInstance.getId() == id) {					//If game id exist return game instance 
				return gameInstance;
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

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		//go over the list of games, if found with existing name return Game instance
		Iterator <Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {						//Iterate over list of games
			Game gameInstance = gamesIterator.next();			//Set local game variable to next item in the list
			if (gameInstance.getName().equalsIgnoreCase(name)) {//If game name exist return game instance 
				return gameInstance;
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

	/**
	 * Returns the Player whose turn is next
	 * 
	 * @return the Player whose turn is next
	 */
	public long getNextPlayerId() {
		return nextPlayerId;
	}

	/**
	* Returns the Team whose turn is next
	*
	* @return the Team whose turn is next
	*/
	public long getNextTeamId() {
		return nextTeamId;
	}
}
