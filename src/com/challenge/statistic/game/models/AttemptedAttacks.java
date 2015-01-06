/**
 * 
 */
package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 * This class compiles the "Attempted Attacks" statistic .It is a single game stat.
 */
public class AttemptedAttacks implements IStatistic{
	int statValue=0;
	
	@Override
	public int statValue() {
		return statValue;
	}

	public AttemptedAttacks (int points) {
		statValue+=points;
	}

	@Override
	public String toString(){
		return "Number of Attempted Attacks are:"+statValue;
	}
}
