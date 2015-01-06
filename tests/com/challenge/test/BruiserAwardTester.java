package com.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.challenge.achievements.awards.models.BruiserAward;
import com.challenge.achievements.provider.models.BruiserAwardProvider;
import com.challenge.statistic.game.models.DamageDone;
import com.challenge.statistic.helper.IStatistic;


/**
 * 
 * @author Ankit kohli
 *
 */
public class BruiserAwardTester {

	private BruiserAwardProvider bruiserProvider;
	private DamageDone damageDone;
	private Map<Class<? extends IStatistic>, IStatistic> mockStatMap;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		bruiserProvider = new BruiserAwardProvider(mock(BruiserAward.class));
		damageDone = mock(DamageDone.class);
		mockStatMap = mock(Map.class);
	}

	@Test
	public void bruiserAcheivementTrue() {
		when(damageDone.statValue()).thenReturn(501);
		when(mockStatMap.containsKey(DamageDone.class)).thenReturn(true);
		when(mockStatMap.get(DamageDone.class)).thenReturn(damageDone);
		assertTrue(bruiserProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void bruiserAcheivementFalse() {
		when(damageDone.statValue()).thenReturn(500);
		when(mockStatMap.containsKey(DamageDone.class)).thenReturn(true);
		when(mockStatMap.get(DamageDone.class)).thenReturn(damageDone);
		assertFalse(bruiserProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void bruiserAcheivementStatNotPresent() {
		assertFalse(bruiserProvider.isAchievementGained(mockStatMap));
	}


}
