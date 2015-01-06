package com.challenge.game.service.begin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.game.match.GameTeams;
import com.challenge.game.players.helper.PlayerStatistic;
import com.challenge.game.players.models.Player;
import com.challenge.game.service.helper.PlayerAcheivementsFinder;
import com.challenge.statistic.game.models.Assists;
import com.challenge.statistic.game.models.AttemptedAttacks;
import com.challenge.statistic.game.models.CivilianHits;
import com.challenge.statistic.game.models.DamageDone;
import com.challenge.statistic.game.models.FirstHitKills;
import com.challenge.statistic.game.models.Hits;
import com.challenge.statistic.game.models.Kills;
import com.challenge.statistic.game.models.SpellCasts;
import com.challenge.statistic.game.models.SpellDamage;
import com.challenge.statistic.game.models.TimePlayed;
import com.challenge.statistic.historical.models.TotalDurationPlayed;
import com.challenge.statistic.historical.models.TotalGamesPlayed;
import com.challenge.statistic.historical.models.TotalGamesWon;
import com.challenge.statistic.historical.models.TotalKills;

/**
 * 
 * @author Ankit kohli
 * 
 * This is the main driver class of the program .
 * 1. Creates 8 player ,4 in each team i.e team A, team B.
 * 2. calls achievement finder logic
 * 3. prints it to the console.
 */
public class LetTheGameBegin {
	public static void main(String[] args) {
		
		/**
		 * Players are created using random list of statistics
		 */
		PlayerStatistic player1Statistic = new PlayerStatistic()
										  .addStatistic(new Assists(200))
										  .addStatistic(new AttemptedAttacks(300))
										  .addStatistic(new CivilianHits(10))
										  .addStatistic(new DamageDone(600))
										  .addStatistic(new FirstHitKills(150))
										  .addStatistic(new Hits(240))
										  .addStatistic(new Kills(200))
										  .addStatistic(new SpellCasts(100))
										  .addStatistic(new SpellDamage(200))
										  .addStatistic(new TimePlayed(200))
										  .addStatistic(new TotalDurationPlayed(500))
										  .addStatistic(new TotalGamesPlayed(500))
										  .addStatistic(new TotalKills(300))
										  .addStatistic(new TotalGamesWon(600));
		Player pA1 = new Player(121, player1Statistic);

		/*System.out.println("Stats for Player:"+pA1);
		pA1.getPlayerStats().showPlayerStats();*/
		
		PlayerStatistic player2Statistic = new PlayerStatistic()
										 .addStatistic(new Assists(200))
										 .addStatistic(new AttemptedAttacks(1000))
										 .addStatistic(new CivilianHits(200))
										 .addStatistic(new DamageDone(600))
										 .addStatistic(new FirstHitKills(150))
										 .addStatistic(new Hits(500))
										 .addStatistic(new Kills(200))
										 .addStatistic(new SpellCasts(100))
										 .addStatistic(new SpellDamage(200))
										 .addStatistic(new TimePlayed(200))
										 .addStatistic(new TotalDurationPlayed(500))
										 .addStatistic(new TotalGamesPlayed(5000))
										 .addStatistic(new TotalKills(300))
										 .addStatistic(new TotalGamesWon(500));
		Player pA2 = new Player(124, player2Statistic);

		PlayerStatistic player3Statistic = new PlayerStatistic()
										  .addStatistic(new Assists(200))
										  .addStatistic(new AttemptedAttacks(300))
										  .addStatistic(new CivilianHits(30))
		  								  .addStatistic(new DamageDone(300))
		  								  .addStatistic(new FirstHitKills(150))
		  								  .addStatistic(new Hits(50))
		  								  .addStatistic(new Kills(200))
		  								  .addStatistic(new SpellCasts(100))
		  								  .addStatistic(new SpellDamage(200))
		  								  .addStatistic(new TimePlayed(200))
		  								  .addStatistic(new TotalDurationPlayed(500))
		  								  .addStatistic(new TotalGamesPlayed(10))
		  								  .addStatistic(new TotalKills(300))
		  								  .addStatistic(new TotalGamesWon(100));
		Player pA3 = new Player(137, player3Statistic);


		PlayerStatistic player4Statistic = new PlayerStatistic()
											.addStatistic(new Assists(200))
											.addStatistic(new AttemptedAttacks(300))
											.addStatistic(new CivilianHits(10))
											.addStatistic(new DamageDone(500))
											.addStatistic(new FirstHitKills(150))
											.addStatistic(new Hits(240))
											.addStatistic(new Kills(200))
											.addStatistic(new SpellCasts(100))
											.addStatistic(new SpellDamage(200))
											.addStatistic(new TimePlayed(200))
											.addStatistic(new TotalDurationPlayed(500))
											.addStatistic(new TotalGamesPlayed(1000))
											.addStatistic(new TotalKills(300))
											.addStatistic(new TotalGamesWon(199));
		Player pA4 = new Player(142, player4Statistic);

		PlayerStatistic player5Statistic = new PlayerStatistic()
										  .addStatistic(new Assists(200))
										  .addStatistic(new AttemptedAttacks(500))
										  .addStatistic(new CivilianHits(300))
										  .addStatistic(new DamageDone(200))
										  .addStatistic(new FirstHitKills(150))
										  .addStatistic(new Hits(410))
										  .addStatistic(new Kills(200))
										  .addStatistic(new SpellCasts(100))
										  .addStatistic(new SpellDamage(200))
										  .addStatistic(new TimePlayed(200))
										  .addStatistic(new TotalDurationPlayed(500))
										  .addStatistic(new TotalGamesPlayed(2000))
										  .addStatistic(new TotalKills(300))
										  .addStatistic(new TotalGamesWon(100));
		Player pB1 = new Player(189, player5Statistic);



		PlayerStatistic player6Statistic = new PlayerStatistic()
										   .addStatistic(new Assists(200))
										   .addStatistic(new AttemptedAttacks(100))
										   .addStatistic(new CivilianHits(20))
										   .addStatistic(new DamageDone(200))
										   .addStatistic(new FirstHitKills(150))
		  								   .addStatistic(new Hits(30))
		  								   .addStatistic(new Kills(200))
		  								   .addStatistic(new SpellCasts(100))
		  								   .addStatistic(new SpellDamage(200))
		  								   .addStatistic(new TimePlayed(200))
		  								   .addStatistic(new TotalDurationPlayed(500))
		  								   .addStatistic(new TotalGamesPlayed(100))
		  								   .addStatistic(new TotalKills(300))
		  								   .addStatistic(new TotalGamesWon(100));
		Player pB2 = new Player(114, player6Statistic);

		PlayerStatistic player7Statistic = new PlayerStatistic()
											.addStatistic(new Assists(200))
											.addStatistic(new AttemptedAttacks(300))
											.addStatistic(new CivilianHits(50))
											.addStatistic(new DamageDone(600))
											.addStatistic(new FirstHitKills(150))
											.addStatistic(new Hits(100))
											.addStatistic(new Kills(200))
											.addStatistic(new SpellCasts(100))
											.addStatistic(new SpellDamage(200))
		 	 								.addStatistic(new TimePlayed(200))
		 	 								.addStatistic(new TotalDurationPlayed(500))
		 	 								.addStatistic(new TotalGamesPlayed(500))
		 	 								.addStatistic(new TotalKills(300))
		 	 								.addStatistic(new TotalGamesWon(400));
		Player pB3 = new Player(113, player7Statistic);

		PlayerStatistic player8Statistic = new PlayerStatistic()
											.addStatistic(new Assists(200))
											.addStatistic(new AttemptedAttacks(300))
											.addStatistic(new CivilianHits(10))
											.addStatistic(new DamageDone(600))
											.addStatistic(new FirstHitKills(150))
											.addStatistic(new Hits(240))
											.addStatistic(new Kills(200))
											.addStatistic(new SpellCasts(100))
											.addStatistic(new SpellDamage(200))
											.addStatistic(new TimePlayed(200))
											.addStatistic(new TotalDurationPlayed(500))
											.addStatistic(new TotalGamesPlayed(1500))
											.addStatistic(new TotalKills(300))
											.addStatistic(new TotalGamesWon(400));
		Player pB4 = new Player(197, player8Statistic);


		/**
		 * creates team with 4 player in each .
		 */
		GameTeams matchTeams = new GameTeams(new Player[]{pA1,pA2,pA3,pA4}, new Player[]{pB1,pB2,pB3,pB4});
		
		/**
		 * checks if the composition of each team is valid or not .
		 */
		if(matchTeams.isEachteamConfigValid()){
		
			PlayerAcheivementsFinder acheivementsFinder = new PlayerAcheivementsFinder();
		
			/**
			 * @return map of list of achievements player wise .
			 * @logic :  iterates over the player of 2 teams and calls the method to see achievement of each player .
			 */
			Map<Player,List<IAchievement>> playerAchievementsMap = acheivementsFinder.findPlayerAchievements(matchTeams);
		
			System.out.println("====================================BADGE OF HONOR========================================================="+"\n");
			for(Entry<Player,List<IAchievement>> playerAchievements : playerAchievementsMap.entrySet()){
					Player player = playerAchievements.getKey();
					List<IAchievement> achievementsList = playerAchievements.getValue();
					String achievements = Arrays.toString(achievementsList.toArray());
					System.out.println("Achievements for Player : " + player + " ==> " +(achievementsList.size()>0?achievements:" none "));
				}
			}
		else{
			// where team composition is faulty .
				System.out.println("Sorry the game cannot be played due to invalid team members.......");
		}
		
	}
	
}
