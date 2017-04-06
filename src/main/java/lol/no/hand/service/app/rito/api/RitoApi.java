package lol.no.hand.service.app.rito.api;

import lol.no.hand.service.app.rito.api.response.current.game.CurrentGame;
import lol.no.hand.service.app.rito.api.response.history.RecentHistory;
import lol.no.hand.service.app.rito.api.response.summoner.Summoner;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RitoApi {
	// TODO extract api key to yml file and load as property
	@GET("api/lol/LAS/v1.4/summoner/by-name/{name}?api_key=RGAPI-b7fb65d8-d0f0-416f-8789-3f676dc5e588")
	Call<Summoner> findSummoner(@Path("name") String name);

	@GET("observer-mode/rest/consumer/getSpectatorGameInfo/LA2/{summonerId}?api_key=RGAPI-b7fb65d8-d0f0-416f-8789-3f676dc5e588")
	Call<CurrentGame> findCurrentGame(@Path("summonerId") int summonerId);

	@GET("api/lol/LAS/v1.3/game/by-summoner/{summonerId}/recent?api_key=RGAPI-b7fb65d8-d0f0-416f-8789-3f676dc5e588")
	Call<RecentHistory> findRecentHistory(@Path("summonerId") int summonerId);
}
