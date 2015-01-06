/**
 * 
 */
package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 * 
 * This class compiles the "Spell Casts" statistic .It is a single game stat.
 *
 */
public class SpellCasts implements IStatistic {

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	
	public SpellCasts(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Number of Spell Casts are:"+statValue;
	}
}
