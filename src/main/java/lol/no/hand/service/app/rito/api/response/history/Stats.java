package lol.no.hand.service.app.rito.api.response.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {
	private int level;
	private int numDeaths;
	private int minionsKilled;
	private boolean win;
	private int neutralMinionsKilled;
	private int assists;
	private int championsKilled;
	private int item0;
	private int item1;
	private int item2;
	private int item3;
	private int item4;
	private int item5;
	private int item6;
	//in seconds
	private int timePlayed;
	private int wardPlaced;
	private int playerRole;
}
