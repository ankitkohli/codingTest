package com.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.challenge.achievements.awards.models.CitizensProtecterAward;
import com.challenge.achievements.provider.models.CitizenProtecterAwardProvider;
import com.challenge.statistic.game.models.CivilianHits;
import com.challenge.statistic.game.models.Hits;
import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 *
 */
public class CitizenProtecterAwardTester {
	private CitizenProtecterAwardProvider citizenProtecterProvider;
	private CivilianHits civilianHits;
	private Hits hits;
	private Map<Class<? extends IStatistic>, IStatistic> mockStatMap;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		citizenProtecterProvider = new CitizenProtecterAwardProvider(mock(CitizensProtecterAward.class));
		civilianHits = mock(CivilianHits.class);
		hits =mock(Hits.class);
		mockStatMap = mock(Map.class);
	}

	@Test
	public void citizenProtecterAcheivementTrue() {
		when(hits.statValue()).thenReturn(100);
		when(civilianHits.statValue()).thenReturn(19);
		when(mockStatMap.containsKey(CivilianHits.class)).thenReturn(true);
		when(mockStatMap.containsKey(Hits.class)).thenReturn(true);
		when(mockStatMap.get(CivilianHits.class)).thenReturn(civilianHits);
		when(mockStatMap.get(Hits.class)).thenReturn(hits);
		assertTrue(citizenProtecterProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void citizenProtecterAcheivementFalse() {
		when(hits.statValue()).thenReturn(100);
		when(civilianHits.statValue()).thenReturn(20);
		when(mockStatMap.containsKey(CivilianHits.class)).thenReturn(true);
		when(mockStatMap.containsKey(Hits.class)).thenReturn(true);
		when(mockStatMap.get(CivilianHits.class)).thenReturn(civilianHits);
		when(mockStatMap.get(Hits.class)).thenReturn(hits);
		assertFalse(citizenProtecterProvider.isAchievementGained(mockStatMap));
	}
	
	
	@Test
	public void citizenProtecterAcheivementFalseWhenHitsIsZero() {
		when(hits.statValue()).thenReturn(0);
		when(civilianHits.statValue()).thenReturn(20);
		when(mockStatMap.containsKey(CivilianHits.class)).thenReturn(true);
		when(mockStatMap.containsKey(Hits.class)).thenReturn(true);
		when(mockStatMap.get(CivilianHits.class)).thenReturn(civilianHits);
		when(mockStatMap.get(Hits.class)).thenReturn(hits);
		assertFalse(citizenProtecterProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void citizenProtecterAcheivementStatNotPresent() {
		assertFalse(citizenProtecterProvider.isAchievementGained(mockStatMap));
	}

}
