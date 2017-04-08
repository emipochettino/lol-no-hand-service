package lol.no.hand.service.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lol.no.hand.service.app.rito.api.response.current.game.CurrentGame;
import lol.no.hand.service.app.rito.api.response.summoner.Summoner;

@Service
public class CurrentGameService {

	@Autowired
	private RitoService ritoService;

	public CurrentGame findCurrentGame(String summonerName) throws IOException {
		final Summoner summoner = ritoService.findSummoner(summonerName);

		return ritoService.findCurrentGame(summoner.getId());
	}
}
