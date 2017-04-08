package lol.no.hand.service.app.rito.api.response.statistics.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentHistoryStatistics {
	private int summonerId;
	private String summonerName;
	private Integer lastGamePlayedNbr;
	private Float kda;
	private Float kda3;
	private Float kda5;
	private Float lastWinRate;
	private Integer wardPlacedProm;
	private String mostPlayedRole1;
	private String mostPlayedRole2;
	//TODO improve this statistic using scores minionsKilled/gameDuration without count sup role. 
	private Integer minionsKilledProm;
	private Integer mostChampionPlayed1;
	private Integer mostChampionPlayed2;
}
