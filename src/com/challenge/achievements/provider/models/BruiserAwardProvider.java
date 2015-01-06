package com.challenge.achievements.provider.models;

import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.BruiserAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.statistic.game.models.DamageDone;
import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * 
 * This class is used to to see if a statistic qualifies as "BRUISER AWARD" .
 *
 */
public class BruiserAwardProvider implements IAchievementProvider {

	private Class<DamageDone> damageDoneStat;
	private final static int minReq = 500;
	private BruiserAward bruiserAward;
	
	 public BruiserAwardProvider(BruiserAward bruiserAward) {
		this.damageDoneStat=DamageDone.class;
		this.bruiserAward=bruiserAward;
	}
	 
	@Override
	/**
	 *  @param <Class<? extends IStatistic>,IStatistic> map
	 *  @return boolean
	 *  @logic : for doing more than 500 points of damage in one game.
	 */
	public boolean isAchievementGained(
			Map<Class<? extends IStatistic>, IStatistic> map) {
		if(map.containsKey(damageDoneStat)){
			return minReq < map.get(damageDoneStat).statValue();
		}
		return false;
	}

	@Override
	/**
	 * @return achievement qualified.
	 */
	public IAchievement getAchievement() {
		return bruiserAward;
	}

}
