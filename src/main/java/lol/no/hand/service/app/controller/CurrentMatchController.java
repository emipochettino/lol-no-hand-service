package lol.no.hand.service.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lol.no.hand.service.app.rito.api.response.CurrentMatch;
import lol.no.hand.service.app.service.RitoService;

@RestController
@RequestMapping("/v1/api")
public class CurrentMatchController {

	@Autowired
	private RitoService ritoService;

	@RequestMapping(value = "/current-match/{summonerName}", method = RequestMethod.GET)
	public ResponseEntity<CurrentMatch> greeting(@PathVariable(value = "summonerName") String summonerName)
			throws IOException {
		return ResponseEntity.ok(ritoService.findCurrentMatch(summonerName));
	}
}
