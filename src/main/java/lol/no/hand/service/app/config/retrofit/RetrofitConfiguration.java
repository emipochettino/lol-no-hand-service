package lol.no.hand.service.app.config.retrofit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lol.no.hand.service.app.service.SummonerService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfiguration {

	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient();
	}

	@Bean
	public SummonerService summonerService(OkHttpClient client) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://las.api.riotgames.com/api/lol/LAS/v1.4/summoner/")
				.client(client).addConverterFactory(JacksonConverterFactory.create()).build();

		return retrofit.create(SummonerService.class);
	}
}
