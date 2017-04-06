package lol.no.hand.service.app.rito.api.response.current.game;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentGame {
	private long gameId;
	private String gameMode;
	private List<Participant> participants;
}
