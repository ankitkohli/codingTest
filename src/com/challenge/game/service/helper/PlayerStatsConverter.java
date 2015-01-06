package com.challenge.game.service.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.statistic.helper.IStatistic;
/**
 * 
 * @author Ankit kohli
 *
 */
public class PlayerStatsConverter {

	/**
	 * 
	 * @param List<IStatistics> playerStats
	 * @return Map<Class<? extends IStatistic>, IStatistic>
	 * @logic takes the list of statistics of a player and converts that into desired map .
	 */
	public Map<Class<? extends IStatistic>, IStatistic> convertPlayerStatsToMap(List<IStatistic> playerStats){
		Map<Class<? extends IStatistic>, IStatistic> playerStatMap = new HashMap<Class<? extends IStatistic>, IStatistic>();
		if(!playerStats.isEmpty()){
			for(IStatistic statistic : playerStats ){
				playerStatMap.put(statistic.getClass(),statistic);
			}
		}
		return playerStatMap;
	}
}
