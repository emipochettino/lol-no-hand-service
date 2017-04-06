package lol.no.hand.service.app.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lol.no.hand.service.app.rito.api.RitoApi;
import lol.no.hand.service.app.rito.api.response.current.game.CurrentGame;
import lol.no.hand.service.app.rito.api.response.history.RecentHistory;
import lol.no.hand.service.app.rito.api.response.summoner.Summoner;
import retrofit2.Response;

@Service
public class RitoService {
	private static final Map<String, Summoner> SUMMONERS = new HashMap<String, Summoner>();

	@Autowired
	private RitoApi ritoApi;

	public Summoner findSummoner(String summonerName) throws IOException {
		// TODO improve this method. Use custom exceptions
		Optional<Summoner> summoner = Optional.ofNullable(SUMMONERS.get(summonerName.toLowerCase()));
		if (summoner.isPresent()) {
			return summoner.get();
		} else {
			Response<Summoner> response = ritoApi.findSummoner(summonerName).execute();
			if (response.code() == HttpStatus.OK.value()) {
				summoner = Optional.ofNullable(response.body());
				SUMMONERS.put(summonerName.toLowerCase(), summoner.get());
				return summoner.get();
			}
		}
		return null;
	}

	public CurrentGame findCurrentGame(String summonerName) throws IOException {
		final Summoner summoner = findSummoner(summonerName);

		Response<CurrentGame> response = ritoApi.findCurrentGame(summoner.getId()).execute();

		if (response.code() == HttpStatus.OK.value()) {
			return response.body();
		}

		return null;
	}

	public RecentHistory findRecentHistory(int summonerId) throws IOException {
		Response<RecentHistory> response = ritoApi.findRecentHistory(summonerId).execute();

		if (response.code() == HttpStatus.OK.value()) {
			return response.body();
		}

		return null;
	}
}
