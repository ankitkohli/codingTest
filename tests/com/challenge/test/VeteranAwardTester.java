package com.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.challenge.achievements.awards.models.VeteranAward;
import com.challenge.achievements.provider.models.VeteranAwardProvider;
import com.challenge.statistic.helper.IStatistic;
import com.challenge.statistic.historical.models.TotalGamesPlayed;

/**
 * 
 * @author Ankit kohli
 *
 */
public class VeteranAwardTester {


	private VeteranAwardProvider veteranAwardProvider;
	private TotalGamesPlayed gamesPlayed;
	private Map<Class<? extends IStatistic>, IStatistic> mockStatMap;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		 veteranAwardProvider = new VeteranAwardProvider(mock(VeteranAward.class));
		 gamesPlayed = mock(TotalGamesPlayed.class);
		 mockStatMap = mock(Map.class);
	}

	@Test
	public void veteranAcheivementTrue() {
		when(gamesPlayed.statValue()).thenReturn(1001);
		when(mockStatMap.containsKey(TotalGamesPlayed.class)).thenReturn(true);
		when(mockStatMap.get(TotalGamesPlayed.class)).thenReturn(gamesPlayed);
		assertTrue(veteranAwardProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void veteranAchievementFalse() {
		when(gamesPlayed.statValue()).thenReturn(1000);
		when(mockStatMap.containsKey(TotalGamesPlayed.class)).thenReturn(true);
		when(mockStatMap.get(TotalGamesPlayed.class)).thenReturn(gamesPlayed);
		assertFalse(veteranAwardProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void veteranAchievementStatNotPresent() {
		assertFalse(veteranAwardProvider.isAchievementGained(mockStatMap));
	}


}
