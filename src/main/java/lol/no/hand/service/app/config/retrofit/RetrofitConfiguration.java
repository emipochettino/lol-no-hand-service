package lol.no.hand.service.app.config.retrofit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lol.no.hand.service.app.rito.api.RitoApi;
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
	public RitoApi ritoApi(OkHttpClient client) {
		Retrofit retrofit = new Retrofit
				.Builder()
				.baseUrl("https://las.api.riotgames.com/")
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();

		return retrofit.create(RitoApi.class);
	}
}
