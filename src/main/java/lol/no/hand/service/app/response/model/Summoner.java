package lol.no.hand.service.app.response.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
public class Summoner {
	private int id;
	private String name;
	private int summonerLevel;
}
