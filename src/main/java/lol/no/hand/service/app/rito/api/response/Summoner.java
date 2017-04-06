package lol.no.hand.service.app.rito.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lol.no.hand.service.app.deserializer.SummonerDeserializer;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = SummonerDeserializer.class)
public class Summoner {
	@NonNull
	private int id;
	@NonNull
	private String name;
	@NonNull
	private int summonerLevel;
}
