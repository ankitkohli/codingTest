package com.challenge.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.achievements.awards.models.BigWinnerAward;
import com.challenge.achievements.awards.models.VeteranAward;
import com.challenge.achievements.provider.helper.IAchievementProvider;
import com.challenge.achievements.provider.models.BigWinnerAwardProvider;
import com.challenge.achievements.provider.models.VeteranAwardProvider;
import com.challenge.game.players.helper.PlayerStatistic;
import com.challenge.game.service.helper.AcheivementsChecker;
import com.challenge.game.service.helper.PlayerStatsConverter;
import com.challenge.statistic.helper.IStatistic;
import com.challenge.statistic.historical.models.TotalGamesPlayed;
import com.challenge.statistic.historical.models.TotalGamesWon;
/**
 * 
 * @author Ankit kohli
 *
 */
public class AcheivementCheckerTester {
	
	private AcheivementsChecker acheivementsChecker;
	private List<IStatistic> playerStatistics;
	private PlayerStatsConverter converterToMap ;
	
	@Before
	public void setUp() {
		
		acheivementsChecker = new AcheivementsChecker();
		playerStatistics = new ArrayList<IStatistic>();
		converterToMap = new PlayerStatsConverter();
	}
	@Test
	public void returnEmptyListOfAcheivements(){
		
		List<IAchievement> achievements=acheivementsChecker.achievementsChecker(converterToMap.convertPlayerStatsToMap(playerStatistics));
		assertTrue(achievements.isEmpty());
	}
	
	@Test
	public void checkIfAcheivementsAreAdded(){
		/**
		 * Test to verify the input data. 
		 */
		
		VeteranAward veteranAward =new VeteranAward();
		BigWinnerAward bigWinnerAward = new BigWinnerAward();
		
		List<IAchievementProvider> defaultAchievementProviders;	
		defaultAchievementProviders = new ArrayList<IAchievementProvider>();
		defaultAchievementProviders.add(new BigWinnerAwardProvider(bigWinnerAward));
		defaultAchievementProviders.add(new VeteranAwardProvider(veteranAward));
		acheivementsChecker = new AcheivementsChecker(defaultAchievementProviders);
		
		PlayerStatistic statistic = new PlayerStatistic()
										  .addStatistic(new TotalGamesPlayed(2000))	
										  .addStatistic(new TotalGamesWon(400));
		playerStatistics = statistic.getPlayerStatsList();
		
		List<IAchievement> achievements=acheivementsChecker.achievementsChecker(converterToMap.convertPlayerStatsToMap(playerStatistics));
		
		assertTrue(achievements.contains(veteranAward));
		assertTrue(achievements.contains(bigWinnerAward));
	}
	
	
}
