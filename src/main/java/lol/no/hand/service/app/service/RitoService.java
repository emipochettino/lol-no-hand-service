package lol.no.hand.service.app.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lol.no.hand.service.app.response.model.Summoner;
import lol.no.hand.service.app.rito.api.RitoApi;
import retrofit2.Response;

@Service
public class RitoService {
	private static final Map<String, Summoner> SUMMONERS = new HashMap<String, Summoner>();
	
	@Autowired
	private RitoApi ritoApi;
	
	public Summoner findSummoner(String name) throws IOException {
		//TODO improve this method. Use custom exceptions
		Optional<Summoner> summoner = Optional.ofNullable(SUMMONERS.get(name.toLowerCase()));
		if(summoner.isPresent()) {
			return summoner.get();
		} else {
			Response<Summoner> response = ritoApi.findSummoner(name).execute();
			if(response.code() == HttpStatus.OK.value()) {
				summoner = Optional.ofNullable(response.body());
				SUMMONERS.put(name.toLowerCase(), summoner.get());
				return summoner.get();
			}
		}
		return null;
	}
}
