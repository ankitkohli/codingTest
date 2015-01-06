package com.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.challenge.achievements.awards.models.BigWinnerAward;
import com.challenge.achievements.provider.models.BigWinnerAwardProvider;
import com.challenge.statistic.helper.IStatistic;
import com.challenge.statistic.historical.models.TotalGamesWon;

/**
 * 
 * @author Ankit kohli
 *
 */
public class BigWinnerAwardTester {


	private BigWinnerAwardProvider bigWinnerProvider;
	private TotalGamesWon gamesWon;
	private Map<Class<? extends IStatistic>, IStatistic> mockStatMap;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		bigWinnerProvider = new BigWinnerAwardProvider(mock(BigWinnerAward.class));
		gamesWon = mock(TotalGamesWon.class);
		mockStatMap = mock(Map.class);
	}

	@Test
	public void bigWinnerAcheivementTrue() {
		when(gamesWon.statValue()).thenReturn(200);
		when(mockStatMap.containsKey(TotalGamesWon.class)).thenReturn(true);
		when(mockStatMap.get(TotalGamesWon.class)).thenReturn(gamesWon);
		assertTrue(bigWinnerProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void bigWinnerAchievementFalse() {
		when(gamesWon.statValue()).thenReturn(199);
		when(mockStatMap.containsKey(TotalGamesWon.class)).thenReturn(true);
		when(mockStatMap.get(TotalGamesWon.class)).thenReturn(gamesWon);
		assertFalse(bigWinnerProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void bigWinnernAchievementStatNotPresent() {
		assertFalse(bigWinnerProvider.isAchievementGained(mockStatMap));
	}


}
