/**
 * 
 */
package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 * 
 * This class compiles the "Kills" statistic .It is a single game stat.
 *
 */
public class Kills implements IStatistic{

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	public Kills(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Number of Kills are:"+statValue;
	}
}
