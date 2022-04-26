package AnotherStart.BBallAgain;

import AnotherStart.BBallAgain.dao.PlayerRepository;
import AnotherStart.BBallAgain.dto.Player;
import AnotherStart.BBallAgain.dto.Season;
import AnotherStart.BBallAgain.enums.Positions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SpringBootApplication
public class BBallAgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBallAgainApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(
			PlayerRepository playerRepository, MongoTemplate mongoTemplate) {
		return args -> {

			JSONParser jsonParser = new JSONParser();
			try (FileReader reader = new FileReader("C:\\Users\\willd\\PycharmProjects\\espnwebscraper\\formatted_stats.json")){
				JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
				jsonObject.keySet().forEach(keyStr -> {
					Object keyValue = jsonObject.get(keyStr);
					JSONObject keyValueJSon = (JSONObject) keyValue;
					JSONObject seasonJson = (JSONObject) keyValueJSon.get("2022");
					if(seasonJson != null){
						System.out.println(seasonJson.get("Average"));
						Object Average = seasonJson.get("Average");
						Object Positions = keyValueJSon.get("positions");
						Season season = new Season(2022, (Double)seasonJson.get("gp"),
								(Double)seasonJson.get("Average"), (Double)seasonJson.get("points"), (Double)seasonJson.get("rebounds"),
								(Double)seasonJson.get("steals"),(Double) seasonJson.get("assists"), (Double)seasonJson.get("3pm"),
								(Double)seasonJson.get("ftm"), (Double)seasonJson.get("to"), (Double)seasonJson.get("dd"),
								(Double)seasonJson.get("td"), (Double)seasonJson.get("fgm"), (Double)seasonJson.get("minutes"));

						Player newPlayer = new Player((String) keyStr, (Double)Average, (List<Object>)Positions, season);
						playerRepository.findPlayerByName(newPlayer.getName()).ifPresentOrElse(s -> {
							System.out.println("no one added, player exists already.");
						}, () -> {
							playerRepository.insert(newPlayer);
							System.out.println("player added: " + newPlayer);
						});
					}

				});

			}
			//usingMongo(playerRepository, mongoTemplate, player);

		};
	}

	private void usingMongo(PlayerRepository playerRepository, MongoTemplate mongoTemplate, Player player) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Mikal Bridges"));
		List<Player> players = mongoTemplate.find(query, Player.class);
		if (players.isEmpty()){
			playerRepository.insert(player);
		}
		else {
			System.out.println("no one added, player exists already.");
		}
	}

}
