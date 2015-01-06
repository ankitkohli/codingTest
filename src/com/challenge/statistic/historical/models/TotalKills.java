package com.challenge.statistic.historical.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * This class compiles the "Total Kills" statistic .It is a Lifetime stat.
 *
 */
public class TotalKills implements IStatistic{

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}


	public TotalKills(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Total Kill:"+statValue;
	}
}
