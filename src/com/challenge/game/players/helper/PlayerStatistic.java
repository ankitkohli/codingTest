package com.challenge.game.players.helper;

import java.util.ArrayList;
import java.util.List;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 * 
 * This class maintains the list of statistics for a player
 *
 */
public class PlayerStatistic {

	private List<IStatistic> playerStatsList = new ArrayList<IStatistic>();
	
	/**
	 * 
	 * @param statistic
	 * @return player statistic
	 * add a statistic to the list
	 */
	public PlayerStatistic addStatistic(IStatistic statistic){
		playerStatsList.add(statistic);
		return this;
	}
	
	
	public List<IStatistic> getPlayerStatsList() {
		return playerStatsList;
	}

	/**
	 *  method to show the player statistics
	 */
	public void showPlayerStats(){
		for(IStatistic statistic : playerStatsList){
			System.out.println(statistic.toString());
		}
	}
}
