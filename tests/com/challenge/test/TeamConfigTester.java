package com.challenge.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.challenge.game.match.GameTeams;
import com.challenge.game.players.models.Player;

/**
 * 
 * @author Ankit kohli
 *
 */
public class TeamConfigTester {

	private Player[] teamA;
	private Player[] teamB;
	private GameTeams gameTeam;
		
	@Test
	public void teamConfigValid(){
		teamA = new Player[3];
		teamB = new Player[3];
				
		gameTeam = new GameTeams(teamA,teamB);
		assertTrue(gameTeam.isEachteamConfigValid());
	}
	
	@Test
	public void teamConfigInValid(){
		teamA = new Player[3];
		teamB = new Player[5];
				
		gameTeam = new GameTeams(teamA,teamB);
		assertFalse(gameTeam.isEachteamConfigValid());
	}
	
	@Test
	public void teamConfigInValid2(){
		teamA = new Player[6];
		teamB = new Player[6];
				
		gameTeam = new GameTeams(teamA,teamB);
		assertFalse(gameTeam.isEachteamConfigValid());
	}
	
	@Test
	public void teamConfigInValid3(){
		teamA = new Player[2];
		teamB = new Player[2];
				
		gameTeam = new GameTeams(teamA,teamB);
		assertFalse(gameTeam.isEachteamConfigValid());
	}
}
