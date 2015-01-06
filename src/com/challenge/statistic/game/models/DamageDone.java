package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * This class compiles the "Damage Done" statistic .It is a single game stat.
 *
 */
public class DamageDone implements IStatistic {
	
	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	
	public DamageDone(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Amount of Damage Done:"+statValue;
	}
}
