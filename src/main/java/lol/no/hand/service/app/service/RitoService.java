package lol.no.hand.service.app.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		final Response<Summoner> response = ritoApi.findSummoner(summonerName).execute();
		if (response.code() == HttpStatus.OK.value()) {
			final Summoner summoner = response.body();
			SUMMONERS.put(summonerName.toLowerCase(), summoner);
			return summoner;
		}

		return null;
	}

    public CurrentGame findCurrentGame(int summonerId) throws IOException {
		final Response<CurrentGame> response = ritoApi.findCurrentGame(summonerId).execute();

		if (response.code() == HttpStatus.OK.value()) {
			return response.body();
		}

		return null;
	}

	public RecentHistory findRecentHistory(int summonerId) throws IOException {
		final Response<RecentHistory> response = ritoApi.findRecentHistory(summonerId).execute();

		if (response.code() == HttpStatus.OK.value()) {
			return response.body();
		}

		return null;
	}
}
