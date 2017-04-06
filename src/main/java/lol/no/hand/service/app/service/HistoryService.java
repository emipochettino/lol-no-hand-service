package lol.no.hand.service.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lol.no.hand.service.app.rito.api.response.history.RecentHistory;
import lol.no.hand.service.app.rito.api.response.summoner.Summoner;

@Service
public class HistoryService {

	@Autowired
	private RitoService ritoService;

	public RecentHistory findRecentHistoryBySummonerId(int summonerId) throws IOException {
		return ritoService.findRecentHistory(summonerId);
	}
	
	public RecentHistory findRecentHistoryBySummonerName(String summonerName) throws IOException {
		final Summoner summoner = ritoService.findSummoner(summonerName);
		return ritoService.findRecentHistory(summoner.getId());
	}
}
