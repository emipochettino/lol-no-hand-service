package lol.no.hand.service.app.rito.api.response.statistics.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentHistoryStatistics {
	private int summonerId;
	private int summonerName;
	private int lastGamePlayedNbr;
	private float kda;
	private float kda3;
	private float kda5;
	private float lastWinRate;
	private int wardPlacedProm;
	private String mostPlayedRole1;
	private String mostPlayedRole2;
	//TODO improve this statistic using scores minionsKilled/gameDuration without count sup role. 
	private int minionsKilledProm;
	private int mostChampionPlayed;
}
