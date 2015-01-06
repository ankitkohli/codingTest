package com.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.challenge.achievements.awards.models.SharpshooterAward;
import com.challenge.achievements.provider.models.SharpShooterAwardProvider;
import com.challenge.statistic.game.models.AttemptedAttacks;
import com.challenge.statistic.game.models.Hits;
import com.challenge.statistic.helper.IStatistic;

/**
 * 
 * @author Ankit kohli
 *
 */
public class SharpShooterAwardTester {
	private SharpShooterAwardProvider sharpShooterProvider;
	private AttemptedAttacks attemptedHits;
	private Hits hits;
	private Map<Class<? extends IStatistic>, IStatistic> mockStatMap;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		sharpShooterProvider = new SharpShooterAwardProvider(mock(SharpshooterAward.class));
		attemptedHits = mock(AttemptedAttacks.class);
		hits =mock(Hits.class);
		mockStatMap = mock(Map.class);
	}

	@Test
	public void sharpShooterAcheivementTrue() {
		when(attemptedHits.statValue()).thenReturn(1000);
		when(hits.statValue()).thenReturn(750);
		when(mockStatMap.containsKey(AttemptedAttacks.class)).thenReturn(true);
		when(mockStatMap.containsKey(Hits.class)).thenReturn(true);
		when(mockStatMap.get(AttemptedAttacks.class)).thenReturn(attemptedHits);
		when(mockStatMap.get(Hits.class)).thenReturn(hits);
		assertTrue(sharpShooterProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void sharpShooterAcheivementFalse() {
		when(attemptedHits.statValue()).thenReturn(1000);
		when(hits.statValue()).thenReturn(400);
		when(mockStatMap.containsKey(AttemptedAttacks.class)).thenReturn(true);
		when(mockStatMap.containsKey(Hits.class)).thenReturn(true);
		when(mockStatMap.get(AttemptedAttacks.class)).thenReturn(attemptedHits);
		when(mockStatMap.get(Hits.class)).thenReturn(hits);
		assertFalse(sharpShooterProvider.isAchievementGained(mockStatMap));
	}
	
	@Test
	public void sharpShooterAcheivementFalseWhenAttacksisZero() {
		when(attemptedHits.statValue()).thenReturn(0);
		when(hits.statValue()).thenReturn(400);
		when(mockStatMap.containsKey(AttemptedAttacks.class)).thenReturn(true);
		when(mockStatMap.containsKey(Hits.class)).thenReturn(true);
		when(mockStatMap.get(AttemptedAttacks.class)).thenReturn(attemptedHits);
		when(mockStatMap.get(Hits.class)).thenReturn(hits);
		assertFalse(sharpShooterProvider.isAchievementGained(mockStatMap));
	}
	@Test
	public void sharpShooterAcheivementStatNotPresent() {
		assertFalse(sharpShooterProvider.isAchievementGained(mockStatMap));
	}


}
