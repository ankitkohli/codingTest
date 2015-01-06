package com.challenge.achievements.provider.helper;

import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * It is an interface that is implemented by each award providers .
 * This class would be implemented by each of the award providers
 */

public interface IAchievementProvider {

	/**
	 * 
	 * @param map 
	 * @return boolean 
	 * 
	 * This method takes map of statistic class as input to calculate whether a specific 
	 * type of award is applicable on that statistic or not.
	 * This method will include the logic to calculate if the award is 
	 * applicable or not.
	 */
	public boolean isAchievementGained(Map<Class<? extends IStatistic>,IStatistic> map);

	/**
	 * 
	 * @return achievement.
	 * 
	 * This method will return the achievement object that was calculated .
	 */
	IAchievement getAchievement();
}
