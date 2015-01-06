package com.challenge.game.service.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.achievements.awards.helper.IAchievement;
import com.challenge.game.match.GameTeams;
import com.challenge.game.players.models.Player;
/**
 * 
 * @author Ankit kohli
 * This is the main achievement finder class
 * Has 2 main components player statistic converter and achievement checker . 
 */
public class PlayerAcheivementsFinder {

	/**
	 * converter transforms the list of statistics to Map<Class<? extends IStatistic>,IStatistic>
	 */
	PlayerStatsConverter converter;
	/**
	 * checks through the map which achievement qualifies.
	 */
	AcheivementsChecker checker;
	
	public PlayerAcheivementsFinder() {
		this.converter=new PlayerStatsConverter();
		this.checker=new AcheivementsChecker();
	}
	
	/**
	 * 
	 * @param Game Teams matchResult
	 * @return Map<Player,List<IAchievment>>
	 * @logic calls the converter and checker to create the desired map .
	 */
	public Map<Player,List<IAchievement>> findPlayerAchievements (GameTeams matchResult){
		
		Map<Player,List<IAchievement>> map = new HashMap<Player,List<IAchievement>>() ;
		for(Player player : matchResult.teamA){
		
			map.put(player, checker.achievementsChecker
							(converter.convertPlayerStatsToMap
							(player.getPlayerStats().getPlayerStatsList())));
		}
		
		for(Player player : matchResult.teamB){

			map.put(player, checker.achievementsChecker
							(converter.convertPlayerStatsToMap
							(player.getPlayerStats().getPlayerStatsList())));
		
		}
		
		return map;
	}
}
