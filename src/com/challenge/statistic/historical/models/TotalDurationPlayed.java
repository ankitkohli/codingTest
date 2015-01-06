package com.challenge.statistic.historical.models;

import com.challenge.statistic.helper.IStatistic;
/**
 * 
 * @author Ankit kohli
 * This class compiles the "Total Duration Played" statistic .It is a Lifetime  stat.
 */
public class TotalDurationPlayed implements IStatistic{
	
	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	public TotalDurationPlayed(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Total Duration Played:"+statValue;
	}
}
