package com.challenge.achievements.provider.models;

import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.SharpshooterAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.statistic.game.models.AttemptedAttacks;
import com.challenge.statistic.game.models.Hits;
import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * 
 * This class is used to to see if a statistic qualifies as "SHARP SHOOTER AWARD" .
 *
 */
public class SharpShooterAwardProvider implements IAchievementProvider {

	private Class<AttemptedAttacks> attemptedHits;
	private Class<Hits> hits;
	private final static double minReq = .75;
	private SharpshooterAward sharpShooterAward;
	
	public SharpShooterAwardProvider(SharpshooterAward sharpshooterAward) {
		this.attemptedHits=AttemptedAttacks.class;
		this.hits=Hits.class;
		this.sharpShooterAward=sharpshooterAward;
	}
	
	@Override
	/**
	 * @param <Class<? extends IStatistic>,IStatistic> map 
	 * @return boolean
	 * @logic for landing at least 75% of their attack in single game.
	 */
	public boolean isAchievementGained(
			Map<Class<? extends IStatistic>, IStatistic> map) {
		if(map.containsKey(attemptedHits) && map.containsKey(hits)){
			if(map.get(attemptedHits).statValue()>0){
				return ((double)map.get(hits).statValue() / map.get(attemptedHits).statValue()>=minReq);
			}
			return false;
		}
		return false;
	}

	@Override
	/**
	 * @return achievement qualified.
	 */
	public IAchievement getAchievement() {
		return sharpShooterAward;
	}
	

}
