/**
 * 
 */
package com.challenge.statistic.historical.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 *This class compiles the "Total Games Won" statistic .It is a Lifetime stat.
 */
public class TotalGamesWon implements IStatistic {

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	
	public TotalGamesWon(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Total Games Won:"+statValue;
	}
	
	
}
