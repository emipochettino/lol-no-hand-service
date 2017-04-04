package lol.no.hand.service.app.service;

import lol.no.hand.service.app.response.model.Summoner;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SummonerService {
	@GET("by-name/{name}?api_key=RGAPI-b7fb65d8-d0f0-416f-8789-3f676dc5e588")
	Call<Summoner> findSummoner(@Path("name") String name);
	
}
