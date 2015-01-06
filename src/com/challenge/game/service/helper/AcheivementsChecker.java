package com.challenge.game.service.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.BigWinnerAward;
import com.challenge.achievements.awards.models.BruiserAward;
import com.challenge.achievements.awards.models.CitizensProtecterAward;
import com.challenge.achievements.awards.models.SharpshooterAward;
import com.challenge.achievements.awards.models.VeteranAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.achievements.provider.models.BigWinnerAwardProvider;
import com.challenge.achievements.provider.models.BruiserAwardProvider;
import com.challenge.achievements.provider.models.CitizenProtecterAwardProvider;
import com.challenge.achievements.provider.models.SharpShooterAwardProvider;
import com.challenge.achievements.provider.models.VeteranAwardProvider;
import com.challenge.statistic.helper.IStatistic;
/**
 * 
 * @author Ankit kohli
 * This class is used to find the achievement od each player
 *  
 */
public class AcheivementsChecker {

	/**
	 * register a list of default achievement providers that has logic for each achievement.
	 */
	private List<IAchievementProvider> defaultAchievementProviders;
	
	public AcheivementsChecker(List<IAchievementProvider> providers){
		this.defaultAchievementProviders=providers;		
	}
	
	/**
	 * This is used to register the default achievement providers 
	 */
	public AcheivementsChecker() {
		defaultAchievementProviders = new ArrayList<IAchievementProvider>();
		defaultAchievementProviders.add(new BigWinnerAwardProvider(new BigWinnerAward()));
		defaultAchievementProviders.add(new BruiserAwardProvider(new BruiserAward()));
		defaultAchievementProviders.add(new SharpShooterAwardProvider(new SharpshooterAward()));
		defaultAchievementProviders.add(new VeteranAwardProvider(new VeteranAward()));
		defaultAchievementProviders.add(new CitizenProtecterAwardProvider(new CitizensProtecterAward()));
	}
	
	/**
	 * 
	 * @param playerStats <Class<? extends IStatistic>,IStatistic> map
	 * @return List<IAchievement>
	 * @logic each default achievement provider is called to check id statistic qualifies for that award or not.
	 */
	public List<IAchievement> achievementsChecker(Map<Class<? extends IStatistic>, IStatistic> playerStats ){
		List<IAchievement> achievements = new ArrayList<IAchievement>();
		
		if(!playerStats.isEmpty()){
			for(IAchievementProvider provider:defaultAchievementProviders){
				if(provider.isAchievementGained(playerStats)){
					achievements.add(provider.getAchievement());
				}
			}
		}
		return achievements;
	}
}
