package com.challenge.achievements.provider.models;

import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.BigWinnerAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.statistic.helper.IStatistic;
import com.challenge.statistic.historical.models.TotalGamesWon;

/**
 * 
 * @author Ankit kohli
 * 
 * This class is used to to see if a statistic qualifies as "BIG WINNER AWARD" .
 *
 */
public class BigWinnerAwardProvider implements IAchievementProvider{

	private Class<TotalGamesWon> gamesWonStat;
	private final static int minReq =200;
	private BigWinnerAward acheivement;
	
	 public BigWinnerAwardProvider(BigWinnerAward acheivement) {
		 this.gamesWonStat=TotalGamesWon.class;
		 this.acheivement=acheivement;
	}
	

	@Override
	/**
	 *  @param <Class<? extends IStatistic>,IStatistic> map
	 *  @return boolean
	 *  @logic  Total games won in lifetime must be 200 or more.
	 */
	public boolean isAchievementGained(
			Map<Class<? extends IStatistic>, IStatistic> map) {
		if(map.containsKey(gamesWonStat))
			return minReq<= map.get(gamesWonStat).statValue();
		
		return false;
	}

	@Override
	/**
	 * @return achievement qualified.
	 */
	public IAchievement getAchievement() {
		return acheivement;
	}

}
