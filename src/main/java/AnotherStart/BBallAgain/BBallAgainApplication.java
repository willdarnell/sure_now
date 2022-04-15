package AnotherStart.BBallAgain;

import AnotherStart.BBallAgain.dao.PlayerRepository;
import AnotherStart.BBallAgain.dto.Player;
import AnotherStart.BBallAgain.dto.Positions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class BBallAgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BBallAgainApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(
			PlayerRepository playerRepository, MongoTemplate mongoTemplate) {
		return args -> {
			Player player = new Player("Nikola Jokic",  65, List.of(Positions.PF)  );
			//usingMongo(playerRepository, mongoTemplate, player);
			playerRepository.findPlayerByName(player.getName()).ifPresentOrElse(s -> {
				System.out.println("no one added, player exists already.");
			}, () -> {
				playerRepository.insert(player);
				System.out.println("player added" + player.getName());
			});
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
