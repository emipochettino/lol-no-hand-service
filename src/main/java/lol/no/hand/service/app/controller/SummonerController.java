package lol.no.hand.service.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lol.no.hand.service.app.response.model.Summoner;
import lol.no.hand.service.app.rito.api.RitoApi;

@RestController
@RequestMapping("/v1/api")
public class SummonerController {
	
	@Autowired
	private RitoApi summonerService;
	
	@RequestMapping(value = "/summoner/{name}", method = RequestMethod.GET)
	public ResponseEntity<Summoner> greeting(@PathVariable(value = "name") String name) throws IOException {
		return ResponseEntity.ok(summonerService.findSummoner(name).execute().body());
	}
}
