package lol.no.hand.service.app.rito.api.response.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lol.no.hand.service.app.deserializer.SummonerDeserializer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = SummonerDeserializer.class)
public class Summoner {

	private int id;
	private String name;
	private int summonerLevel;
}
