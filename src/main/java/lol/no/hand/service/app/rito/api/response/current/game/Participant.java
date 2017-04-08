package lol.no.hand.service.app.rito.api.response.current.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Participant {
	private int championId;
	private String summonerName;
	private int teamId;
	private int summonerId;
}
