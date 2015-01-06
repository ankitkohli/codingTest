/**
 * 
 */
package com.challenge.game.players.models;

import com.challenge.game.players.helper.PlayerStatistic;

/**
 * @author Ankit kohli
 * 
 * This class maintains the Player of the game.
 * @Id is the unique identifier .
 * 
 */
public class Player {

	private Integer id ;
	
	/**
	 * Is used to store the player statistics that is used to
	 * call the achievements finder logic .
	 */
	private PlayerStatistic playerStats;
	
	/**
	 * creates a new player with no player statistics
	 * @param id
	 */
	public Player(Integer id){
		this(id,new PlayerStatistic());
	}
	
	/**
	 * creates a player with statistics passed .
	 * @param id
	 * @param playerStats
	 */
	public Player(Integer id,PlayerStatistic playerStats){
		this.id=id;
		this.playerStats=playerStats;
	}
	
	public PlayerStatistic getPlayerStats(){
		return this.playerStats;
	}
	
	@Override
	public String toString(){
		return id.toString();
	}
	
}
