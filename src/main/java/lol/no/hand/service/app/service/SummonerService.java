package lol.no.hand.service.app.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lol.no.hand.service.app.rito.api.response.summoner.Summoner;

@Service
public class SummonerService {
	private static final Map<String, Summoner> SUMMONERS = new HashMap<String, Summoner>();

	@Autowired
	private RitoService ritoService;

	public Summoner findSummoner(String summonerName) throws IOException {
		// TODO improve this method. Use custom exceptions
		Optional<Summoner> summoner = Optional.ofNullable(SUMMONERS.get(summonerName.toLowerCase()));
		if (summoner.isPresent()) {
			return summoner.get();
		} else {
			final Summoner response = ritoService.findSummoner(summonerName);
			SUMMONERS.put(summonerName.toLowerCase(), response);
			return response;
		}
	}

}
