package lol.no.hand.service.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lol.no.hand.service.app.rito.api.response.history.RecentHistory;
import lol.no.hand.service.app.service.HistoryService;

@RestController
@RequestMapping("/v1/api")
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@RequestMapping(value = "/recent-history/{summonerId}", method = RequestMethod.GET)
	public ResponseEntity<RecentHistory> findRecentHistoryBySummonerId(@PathVariable(value = "summonerId") int summonerId)
			throws IOException {
		return ResponseEntity.ok(historyService.findRecentHistoryBySummonerId(summonerId));
	}
	
	@RequestMapping(value = "/recent-history/by-name/{summonerName}", method = RequestMethod.GET)
	public ResponseEntity<RecentHistory> findRecentHistoryBySummonerName(@PathVariable(value = "summonerName") String summonerName)
			throws IOException {
		return ResponseEntity.ok(historyService.findRecentHistoryBySummonerName(summonerName));
	}
}
