package lol.no.hand.service.app.rito.api.response.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
	private int gameId;
	private String gameMode;
	private String subType;
	private int teamId;
	private int championId;
	private int spell1;
	private int spell2;
	private Stats stats;
}
