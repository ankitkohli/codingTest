package com.challenge.game.match;

import com.challenge.game.players.models.Player;

/**
 * 
 * @author Ankit kohli
 * 
 * This class contains the composition of 2 teams that are playing in the game.
 * A team is an array of players.
 */
public class GameTeams {

	public Player[] teamA;
	public Player[] teamB;
	
	
	public GameTeams(Player[]teamA,Player[] teamB){
		this.teamA=teamA;
		this.teamB=teamB;
	}

/**
 * method to check the composition of team
 * @return boolean
 * @logic checks if the number of player in each team are balanced and are between 3-5 
 */
	public boolean isEachteamConfigValid() {
		if((teamA.length>2 && teamA.length<6) && (teamB.length>2 && teamB.length<6) && (teamA.length==teamB.length))
			return true;
		return false;
	}
}
