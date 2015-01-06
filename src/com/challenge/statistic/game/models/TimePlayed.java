/**
 * 
 */
package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 *
 *This class compiles the "Time Played" statistic .It is a single game stat.
 */
public class TimePlayed implements IStatistic{

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	
	public TimePlayed(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Amount of Time Played is:"+statValue;
	}
}
