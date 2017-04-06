package lol.no.hand.service.app.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import lol.no.hand.service.app.rito.api.response.Summoner;

public class SummonerDeserializer extends JsonDeserializer<Summoner> {
	@Override
	public Summoner deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
		final JsonNode node = jp.readValueAsTree();
		return Summoner.builder()
				.name(node.findPath("name").asText())
				.id(node.findPath("id").asInt())
				.summonerLevel(node.findPath("summonerLevel").asInt())
				.build();
	}
}
