package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * 
 * This class compiles the "First Hit Kills" statistic .It is a single game stat.
 *
 */
public class FirstHitKills implements IStatistic{

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}


	public FirstHitKills(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Number of firts Hit Kills are:"+statValue;
	}
}
