package lol.no.hand.service.app.rito.api.response.history;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentHistory {
	private int summonerId;
	private List<Game> games;
}
