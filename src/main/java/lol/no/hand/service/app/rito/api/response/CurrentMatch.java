package lol.no.hand.service.app.rito.api.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentMatch {
	private long gameId;
	private String gameMode;
	private List<Participant> participants;
}
