package com.challenge.achievements.provider.models;

import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.VeteranAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.statistic.helper.IStatistic;
import com.challenge.statistic.historical.models.TotalGamesPlayed;

/**
 * 
 * @author Ankit kohli
 * 
 * This class is used to to see if a statistic qualifies as "VETERAN AWARD" .
 *
 */
public class VeteranAwardProvider implements IAchievementProvider {

	private Class<TotalGamesPlayed> totalGamesPlayedStat;
	private VeteranAward veteranAward;
	private final static int minReq = 1000;
	
	
	 public VeteranAwardProvider(VeteranAward veteranAward) {
		 	this.totalGamesPlayedStat=TotalGamesPlayed.class;
		 	this.veteranAward=veteranAward;
	 }
	 
 
	@Override
	/**
	 * @param <Class<? extends IStatistic>,IStatistic> map 
	 * @return boolean
	 * @logic for playing more than 1000 games in lifetime.
	 */
	
	public boolean isAchievementGained(
			Map<Class<? extends IStatistic>, IStatistic> map) {
		if(map.containsKey(totalGamesPlayedStat)){
			return map.get(totalGamesPlayedStat).statValue()>minReq;
		}
		return false;
	}

	@Override
	/**
	 * @return achievement qualified.
	 */
	public IAchievement getAchievement() {
		return veteranAward;
	}
	

}
