package com.challenge.achievements.provider.models;

import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.CitizensProtecterAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.statistic.game.models.CivilianHits;
import com.challenge.statistic.game.models.Hits;
import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 * 
 * This class is used to to see if a statistic qualifies as "CITIZEN PROTECTOR AWARD" .
 * This was created other than the ones specified in the test.
 *
 */
public class CitizenProtecterAwardProvider implements IAchievementProvider {

	private Class<CivilianHits> civiliansKilled;
	private Class<Hits> hits;
	private final static double maxReq = .20;
	private CitizensProtecterAward citizenProtecterAward;
	
	public CitizenProtecterAwardProvider(CitizensProtecterAward citizenProtecterAward) {
		this.civiliansKilled=CivilianHits.class;
		this.hits=Hits.class;
		this.citizenProtecterAward=citizenProtecterAward;
	}
	
	@Override
	/**
	 * @param <Class<? extends IStatistic>,IStatistic> map 
	 * @return boolean
	 * @logic : number of civilians killed should be less than 20% of number of hits in single game.  
	 */
	public boolean isAchievementGained(
			Map<Class<? extends IStatistic>, IStatistic> map) {
		if(map.containsKey(civiliansKilled) && map.containsKey(hits)){
			if(map.get(civiliansKilled).statValue()>0 && map.get(hits).statValue()>0){
				return ((double)map.get(civiliansKilled).statValue()/ map.get(hits).statValue()<maxReq);
			}
			return false;
		}
		return false;
	}

	@Override
	/**
	 * @return achievement qualified .
	 */
	public IAchievement getAchievement() {
		return citizenProtecterAward;
	}
	


}
