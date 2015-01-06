/**
 * 
 */
package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * @author Ankit kohli
 * 
 * This class compiles the "Spell Damage" statistic .It is a single game stat.
 *
 */
public class SpellDamage implements IStatistic {

	int statValue=0;
	@Override
	public int statValue() {
		return statValue;
	}

	
	public SpellDamage(int points) {
		statValue+=points;
	}
	
	@Override
	public String toString(){
		return "Number of Spell Damage are:"+statValue;
	}
}
