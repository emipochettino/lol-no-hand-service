package lol.no.hand.service.app.rito.api;

import lol.no.hand.service.app.rito.api.response.current.game.CurrentGame;
import lol.no.hand.service.app.rito.api.response.history.RecentHistory;
import lol.no.hand.service.app.rito.api.response.summoner.Summoner;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RitoApi {
    static final String API_KEY = "RGAPI-d0776d18-323a-495b-9246-2b3f3fba872f";

    // TODO extract api key to yml file and load as property
    @GET("api/lol/LAS/v1.4/summoner/by-name/{name}?api_key=" + API_KEY)
    Call<Summoner> findSummoner(@Path("name") String name);

    @GET("observer-mode/rest/consumer/getSpectatorGameInfo/LA2/{summonerId}?api_key=" + API_KEY)
    Call<CurrentGame> findCurrentGame(@Path("summonerId") int summonerId);

    @GET("api/lol/LAS/v1.3/game/by-summoner/{summonerId}/recent?api_key=" + API_KEY)
    Call<RecentHistory> findRecentHistory(@Path("summonerId") int summonerId);

    @GET("api/lol/LAS/v2.5/league/by-summoner/{summonerId}/entry?api_key=" + API_KEY)
    Call<RecentHistory> findLeague(@Path("summonerId") int summonerId);
}
