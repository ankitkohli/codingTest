package com.challenge.statistic.game.models;

import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * This class compiles the "Civilian killed" statistic .It is a single game stat.
 * This is other than the ones specified in the test.
 */
public class CivilianHits implements IStatistic {
	 
		int statValue=0;
		@Override
		public int statValue() {
			return statValue;
		}

		public CivilianHits(int points){
			statValue+=points;
		}
		

		@Override
		public String toString(){
			return "Number of Civilians killed are:"+statValue;
		}

}
